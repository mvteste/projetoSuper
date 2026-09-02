package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public abstract class AbstractEntityView<T> extends JPanel {
    private final JPanel form = new JPanel(new GridBagLayout());
    private final Map<String, JTextField> fields = new LinkedHashMap<>();
    private final DefaultTableModel tableModel;
    private final JTable table;
    private final List<T> entities = new ArrayList<>();
    private final JButton saveButton = new JButton("Salvar");
    private final JButton updateButton = new JButton("Atualizar");
    private final JButton deleteButton = new JButton("Excluir");

    protected AbstractEntityView(String title, String... columns) {
        super(new BorderLayout(8, 8));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        form.setBorder(BorderFactory.createTitledBorder(title));
        tableModel = new DefaultTableModel(columns, 0) {
            @Override public boolean isCellEditable(int row, int column) { return false; }
        };
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting() && table.getSelectedRow() >= 0) {
                fillForm(entities.get(table.convertRowIndexToModel(table.getSelectedRow())));
            }
        });
    }

    protected final void addField(String key, String label) {
        int row = fields.size();
        GridBagConstraints left = constraints(0, row, 0);
        form.add(new JLabel(label + ":"), left);
        JTextField field = new JTextField(18);
        fields.put(key, field);
        form.add(field, constraints(1, row, 1));
    }

    protected final void buildView() {
        JPanel top = new JPanel(new BorderLayout());
        top.add(form, BorderLayout.CENTER);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton newButton = new JButton("Novo");
        JButton reloadButton = new JButton("Recarregar");
        buttons.add(newButton);
        buttons.add(saveButton);
        buttons.add(updateButton);
        buttons.add(deleteButton);
        buttons.add(reloadButton);
        top.add(buttons, BorderLayout.SOUTH);
        add(top, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);

        newButton.addActionListener(event -> clearForm());
        reloadButton.addActionListener(event -> reload());
        saveButton.addActionListener(event -> execute("salvar", () -> saveEntity()));
        updateButton.addActionListener(event -> executeSelected("atualizar", this::updateEntity));
        deleteButton.addActionListener(event -> executeSelected(deleteButton.getText().toLowerCase(), this::deleteEntity));
    }

    protected final void configureActions(boolean save, boolean update, boolean delete) {
        saveButton.setVisible(save);
        updateButton.setVisible(update);
        deleteButton.setVisible(delete);
    }

    protected final void setDeleteLabel(String label) { deleteButton.setText(label); }
    protected final String text(String key) { return field(key).getText().trim(); }
    protected final int integer(String key) {
        try { return Integer.parseInt(text(key)); }
        catch (NumberFormatException e) { throw new IllegalArgumentException("O campo deve conter um número inteiro válido: " + key); }
    }
    protected final Integer optionalInteger(String key) { return text(key).isBlank() ? null : integer(key); }
    protected final double decimal(String key) {
        try { return Double.parseDouble(text(key).replace(',', '.')); }
        catch (NumberFormatException e) { throw new IllegalArgumentException("O campo deve conter um número válido: " + key); }
    }
    protected final void value(String key, Object value) { field(key).setText(value == null ? "" : String.valueOf(value)); }

    public final void reload() {
        try {
            List<T> loaded = loadEntities();
            entities.clear();
            tableModel.setRowCount(0);
            if (loaded != null) {
                entities.addAll(loaded);
                for (T entity : loaded) tableModel.addRow(toRow(entity));
            }
        } catch (RuntimeException e) {
            showError("Não foi possível carregar os dados.", e);
        }
    }

    protected abstract List<T> loadEntities();
    protected abstract Object[] toRow(T entity);
    protected abstract void fillForm(T entity);
    protected abstract void saveEntity();
    protected abstract void updateEntity(T entity);
    protected abstract void deleteEntity(T entity);

    private void execute(String action, Runnable operation) {
        try {
            operation.run();
            reload();
            clearForm();
            JOptionPane.showMessageDialog(this, "Operação realizada com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (RuntimeException e) {
            showError("Não foi possível " + action + " o registro.", e);
        }
    }

    private void executeSelected(String action, EntityOperation<T> operation) {
        int viewRow = table.getSelectedRow();
        if (viewRow < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um registro na tabela.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        T entity = entities.get(table.convertRowIndexToModel(viewRow));
        execute(action, () -> operation.run(entity));
    }

    private void clearForm() {
        fields.values().forEach(field -> field.setText(""));
        table.clearSelection();
    }

    private JTextField field(String key) {
        JTextField field = fields.get(key);
        if (field == null) throw new IllegalArgumentException("Campo não configurado: " + key);
        return field;
    }

    private void showError(String message, Throwable error) {
        Throwable cause = error;
        while (cause.getCause() != null) cause = cause.getCause();
        String detail = cause.getMessage() == null ? cause.getClass().getSimpleName() : cause.getMessage();
        JOptionPane.showMessageDialog(this, message + "\n" + detail, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    private static GridBagConstraints constraints(int x, int y, double weight) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = x; c.gridy = y; c.weightx = weight;
        c.fill = x == 1 ? GridBagConstraints.HORIZONTAL : GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(3, 5, 3, 5);
        return c;
    }

    @FunctionalInterface private interface EntityOperation<E> { void run(E entity); }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jframes.atividades;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
/**
 *
 * @author tadeo
 */
public class CadastroProduto extends JFrame {
    
    private JTextField txtId;
    private JTextField txtNome;
    private JTextField txtValor;
    private JTextField txtQuantidade;
    
    private JTable tabela;
    private DefaultTableModel modelo;
    
    private JButton btnCadastrar;
    private JButton btnLimpar;
    
    public CadastroProduto() {
        
        setTitle("Cadastro de Produtos");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel painelCampos = new JPanel(new GridLayout(5, 2, 5, 5));
        
        painelCampos.add(new JLabel("ID:"));
        txtId = new JTextField();
        painelCampos.add(txtId);
        
        painelCampos.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        painelCampos.add(txtNome);
        
        painelCampos.add(new JLabel("Valor Unitário:"));
        txtValor = new JTextField();
        painelCampos.add(txtValor);
        
        painelCampos.add(new JLabel("Quatidade de Estoque:"));
        txtQuantidade = new JTextField();
        painelCampos.add(txtQuantidade);
        
        btnCadastrar = new JButton("Cadastrar");
        btnLimpar = new JButton("Limpar");
        
        painelCampos.add(btnCadastrar);
        painelCampos.add(btnLimpar);
        
        modelo = new DefaultTableModel(new Object[]{"ID", "Nome", "Valor Unitário", "Quantidade de Estoque"}, 0);
        
        tabela = new JTable(modelo);
        
        JScrollPane scroll = new JScrollPane(tabela);
        
        add(painelCampos, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        
        btnCadastrar.addActionListener(e -> cadastrarProduto());
        btnLimpar.addActionListener(e -> limparCampos());
    }
    private void cadastrarProduto(){
        try {
            int id = Integer.parseInt(txtId.getText());
            String nome = txtNome.getText();
            float valor = Float.parseFloat(txtValor.getText());
            int qtd = Integer.parseInt(txtQuantidade.getText());
            
            modelo.addRow(new Object[]{
                id,
                nome,
                valor,
                qtd
            });
            
            limparCampos();
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                     this,
                     "Preencha os campos corretamente!",
                     "Erro",
                     JOptionPane.ERROR_MESSAGE);
        }
    }
    private void limparCampos(){
        txtId.setText("");
        txtNome.setText("");
        txtValor.setText("");
        txtQuantidade.setText("");
        txtId.requestFocus();
    }    
  public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> {
          new CadastroProduto().setVisible(true);
      });
    } 
}
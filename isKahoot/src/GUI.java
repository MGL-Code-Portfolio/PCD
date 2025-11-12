import javax.swing.*;
import java.awt.*;

public class GUI {

    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public GUI() {
        // Cria janela principal
        frame = new JFrame("isKahoot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);

        // Painel principal com CardLayout
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Adiciona telas
        cardPanel.add(createLobbyPanel(), "LOBBY");
        cardPanel.add(createQuestionPanel(), "QUESTION");
        cardPanel.add(createResultsPanel(), "RESULTS");

        frame.getContentPane().add(cardPanel);
        cardLayout.show(cardPanel, "LOBBY");
        frame.setVisible(true);
    }

    private JPanel createLobbyPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));

        // Painel vertical para título e código
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Bem-vindo ao isKahoot!", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(32f));

        JLabel cod = new JLabel("Código do jogo: "                       , SwingConstants.CENTER);
        /// ADICONAR CODIGO DA SALAAAAAAAAAAAAAAAAAAAAAAA |||||||||||||||||
        cod.setFont(cod.getFont().deriveFont(20f));

        // Centraliza ambos no painel vertical
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        cod.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Espaçamento
        centerPanel.add(Box.createVerticalGlue());
        centerPanel.add(title);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 10))); // espaço entre linhas
        centerPanel.add(cod);
        centerPanel.add(Box.createVerticalGlue());

        panel.add(centerPanel, BorderLayout.CENTER);

        JButton startButton = new JButton("Iniciar Jogo");
        startButton.setFont(startButton.getFont().deriveFont(18f));
        startButton.addActionListener(e -> cardLayout.show(cardPanel, "QUESTION"));

        JPanel south = new JPanel();
        south.add(startButton);
        panel.add(south, BorderLayout.SOUTH);

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        return panel;
    }


    private JPanel createQuestionPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));

        JLabel questionLabel = new JLabel("Qual é a capital de Portugal?", SwingConstants.CENTER);
        questionLabel.setFont(questionLabel.getFont().deriveFont(24f));
        panel.add(questionLabel, BorderLayout.NORTH);

        // Alternativas em grelha 2x2
        JPanel answersPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        String[] respostas = {"Madrid", "Lisboa", "Porto", "Coimbra"};
        Color[] cores = {
                new Color(220, 53, 69),   // vermelho
                new Color(40, 167, 69),   // verde
                new Color(0, 123, 255),   // azul
                new Color(255, 193, 7)    // amarelo
        };

        for (int i = 0; i < 4; i++) {
            JButton btn = new JButton(respostas[i]);
            btn.setFont(btn.getFont().deriveFont(18f));
            btn.setBackground(cores[i]);
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            answersPanel.add(btn);
        }

        panel.add(answersPanel, BorderLayout.CENTER);

        // Rodapé com tempo e botão de próxima
        JPanel south = new JPanel(new BorderLayout(10, 10));
        JLabel timerLabel = new JLabel("Tempo: 20", SwingConstants.LEFT);
        timerLabel.setFont(timerLabel.getFont().deriveFont(16f));
        south.add(timerLabel, BorderLayout.WEST);

        JButton nextButton = new JButton("Próxima Pergunta");
        nextButton.setFont(nextButton.getFont().deriveFont(16f));
        nextButton.addActionListener(e -> cardLayout.show(cardPanel, "RESULTS"));
        south.add(nextButton, BorderLayout.EAST);

        panel.add(south, BorderLayout.SOUTH);

        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        return panel;
    }

    private JPanel createResultsPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));

        JLabel title = new JLabel("Resultados", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(28f));
        panel.add(title, BorderLayout.NORTH);

        JTextArea resultsArea = new JTextArea(
                "1º João - 980 pts\n" +
                        "2º Ana - 850 pts\n" +
                        "3º Carlos - 820 pts\n\n" +
                        "Parabéns aos vencedores!"
        );
        resultsArea.setEditable(false);
        resultsArea.setFont(resultsArea.getFont().deriveFont(16f));
        resultsArea.setBackground(new Color(245, 245, 245));
        panel.add(new JScrollPane(resultsArea), BorderLayout.CENTER);

        JButton backButton = new JButton("Voltar ao Lobby");
        backButton.setFont(backButton.getFont().deriveFont(16f));
        backButton.addActionListener(e -> cardLayout.show(cardPanel, "LOBBY"));

        JPanel south = new JPanel();
        south.add(backButton);
        panel.add(south, BorderLayout.SOUTH);

        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUI::new);
    }
}

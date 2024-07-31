import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizTimerApp extends JFrame 
{
    private JLabel questionLabel, timerLabel;
    private JRadioButton[] options;
    private JButton nextButton;
    private ButtonGroup group;
    private Timer timer;
    private int currentQuestionIndex=0;
    private int score=0;
    private int timeLeft=30; // 30 seconds per question

    // Sample questions and answers
    private String[][] questions = {
        {"Who won the ICC Cricket World Cup in 2019?", "India", "Australia", "England", "New Zealand", "England"},
        {"Which cricketer has scored the most runs in international cricket?", "Sachin Tendulkar", "Ricky Ponting", "Brian Lara", "Virat Kohli", "Sachin Tendulkar"},
        {"Where is the Lord's Cricket Ground located?", "Sydney", "London", "New York", "Melbourne", "London"},
        {"What is the highest individual score in a Test inning?", "365", "400", "375", "380", "400"},
        {"Who is known as the 'God of Cricket'?", "Brian Lara", "Ricky Ponting", "Sachin Tendulkar", "Virat Kohli", "Sachin Tendulkar"}
    };

    public QuizTimerApp() 
    {
        setTitle("Cricket Quiz");
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(230, 230, 250)); // Light lavender background

        // Question label
        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        questionLabel.setForeground(new Color(0, 51, 102)); // Navy blue
        questionLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(questionLabel, BorderLayout.NORTH);

        // Options
        options = new JRadioButton[4];
        group = new ButtonGroup();
        JPanel optionsPanel = new JPanel(new GridLayout(4, 1));
        optionsPanel.setBackground(new Color(240, 240, 240));
        for (int i = 0; i < options.length; i++) {
            options[i] = new JRadioButton();
            options[i].setFont(new Font("Verdana", Font.PLAIN, 16));
            options[i].setForeground(new Color(0, 0, 102)); // Dark blue
            options[i].setBackground(new Color(240, 240, 240)); // Consistent background
            group.add(options[i]);
            optionsPanel.add(options[i]);
        }
        add(optionsPanel, BorderLayout.CENTER);

        // Timer label
        timerLabel = new JLabel("Time left: 30s");
        timerLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        timerLabel.setForeground(Color.RED);
        timerLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(timerLabel, BorderLayout.WEST);

        // Next button
        nextButton = new JButton("Next");
        nextButton.setFont(new Font("Arial", Font.BOLD, 16));
        nextButton.setForeground(Color.WHITE);
        nextButton.setBackground(new Color(0, 102, 204)); // Blue button
        nextButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // Thick border
        nextButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                checkAnswer();
                currentQuestionIndex++;
                if(currentQuestionIndex<questions.length)
                {
                    loadQuestion(currentQuestionIndex);
                }
                else
                {
                    timer.stop();
                    JOptionPane.showMessageDialog(null, "Quiz finished! Your score: " + score);
                    System.exit(0);
                }
            }
        });
        add(nextButton, BorderLayout.SOUTH);

        loadQuestion(currentQuestionIndex);

        // Timer
        timer=new Timer(1000, new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                timeLeft--;
                timerLabel.setText("Time left: " + timeLeft + "s");
                if(timeLeft<=0)
                {
                    nextButton.doClick(); // Move to the next question
                }
            }
        });
        timer.start();
    }

    private void loadQuestion(int questionIndex) 
    {
        questionLabel.setText(questions[questionIndex][0]);
        for(int i=0;i<options.length;i++)
        {
            options[i].setText(questions[questionIndex][i + 1]);
            options[i].setSelected(false);
        }
        timeLeft=30; // Reset timer for the next question
        timerLabel.setText("Time left: " + timeLeft + "s");
    }

    private void checkAnswer()
    {
        String correctAnswer=questions[currentQuestionIndex][5];
        for(JRadioButton option : options)
        {
            if (option.isSelected() && option.getText().equals(correctAnswer))
            {
                score++;
            }
        }
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new QuizTimerApp().setVisible(true);
            }
        });
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables


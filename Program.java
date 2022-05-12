import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Game {
    JFrame window;
    Container con;
    JPanel titleNamePanel, subtitleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel,
    playerPanel;
    JLabel titleNameLabel, subtitleNameLabel, yearLabel, yearLabelNumber, placeLabel, placeLabelName;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 50);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 25);
    Font smallFont = new Font("Times New Roman", Font.PLAIN, 20);
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    int year;
    String place, position;

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

    public static void main(String[] args) {

        new Game();
    }

    public Game(){
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(20, 100, 750, 100);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("Creative Adaptation Project");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        subtitleNamePanel = new JPanel();
        subtitleNamePanel.setBounds(300, 200, 200, 50);
        subtitleNamePanel.setBackground(Color.black);
        subtitleNameLabel = new JLabel("by Ziyu Zhao");
        subtitleNameLabel.setForeground(Color.white);
        subtitleNameLabel.setFont(normalFont);


        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);

        titleNamePanel.add(titleNameLabel);
        subtitleNamePanel.add(subtitleNameLabel);
        startButtonPanel.add(startButton);
        con.add(titleNamePanel);
        con.add(subtitleNamePanel);
        con.add(startButtonPanel);
    }

    public void createGameScreen() {


        titleNamePanel.setVisible(false);
        subtitleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea("This is the main text area");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(smallFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(240, 400, 300, 120);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        con.add(choiceButtonPanel);


        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(smallFont);
        choiceButtonPanel.add(choice1);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");

        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(smallFont);
        choiceButtonPanel.add(choice2);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");

        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(smallFont);
        choiceButtonPanel.add(choice3);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");

        choice4 = new JButton("Choice 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(smallFont);
        choiceButtonPanel.add(choice4);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");

        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1,4));
        con.add(playerPanel);
        yearLabel = new JLabel("Year: ");
        yearLabel.setFont(normalFont);
        yearLabel.setForeground(Color.white);
        playerPanel.add(yearLabel);
        yearLabelNumber = new JLabel();
        yearLabelNumber.setFont(normalFont);
        yearLabelNumber.setForeground(Color.white);
        playerPanel.add(yearLabelNumber);
        placeLabel = new JLabel("Place: ");
        placeLabel.setFont(normalFont);
        placeLabel.setForeground(Color.white);
        playerPanel.add(placeLabel);
        placeLabelName = new JLabel();
        placeLabelName.setFont(normalFont);
        placeLabelName.setForeground(Color.white);
        playerPanel.add(placeLabelName);
        playerSetUp();
    }

    public void playerSetUp() {
        year = 2023;
        place = "Robledo";
        yearLabelNumber.setText(year + "");
        placeLabelName.setText(place);
        intro();
    }

    public void intro() {
        year++;
        position = "intro";
        mainTextArea.setText("The year is now " + year + ".\nYou are living with your family in " + place + ".\n" +
                "Your father is a Baptist who wants to stay in Robledo and rebuild \nthe community. " +
                "You asked him where he would go if he was forced to \nleave. He showed no sign of wanting to leave." +
                "\n\n \"Rebuilding, fortifying, doing whatever we can do to live and be safe.\"");

        yearLabelNumber.setText("" + year);
        placeLabelName.setText(place);

        choice1.setText("Convince him to leave");
        choice2.setText("Create a new religion");
        choice3.setText("Leave without telling him");
        choice4.setText("Secretly prepare your escape");
    }

    public void convince() {
        position = "convince";
        year++;
        mainTextArea.setText("The year is now " + year + ". \nYou are living with your family in "+ place + ".\n" +
                "You tried to convince your father, but it did not work. \n\n\"Indeed, how can I expect to change " +
                "someone who has believed in\n something for his whole life?\", you thought to yourself.");
        yearLabelNumber.setText("" + year);
        placeLabelName.setText(place);
        choice1.setText("Keep trying");
        choice2.setText("Create a new religion");
        choice3.setText("Leave the family");
        choice4.setText("Secretly prepare for escape");
    }

    public void convinced() {
        position = "convinced";
        place = "Los Angeles";
        year += 3;
        mainTextArea.setText("Three years have gone by. After seeing how badly things have gone wrong\nyour father was finally" +
                " convinced to leave with the family, and you are \nnow in " + place +" with your father, Cory and your 4 brothers." +
                "\n\n\"Belief\nInitiates and guides action--\nOr it does nothing.\"");
        yearLabelNumber.setText("" + year);
        placeLabelName.setText(place);
        choice1.setText("Settle in L.A.");
        choice2.setText("Go to Oregon");
        choice3.setText("Go to Canada");
        choice4.setText("Go South");
    }

    public void canada() {
        position = "canada";
        place = "Canada";
        year += 2;
        mainTextArea.setText("After two years of travelling and battling the crazy people out there, only \nyou, Cory, Gregory" +
                " and Keith made it alive. You have now reached \n" + place + "." +
                "\nDue to the cold climate in Canada, there are many fewer arsonists in \nthe street causing destruction. " +
                "The communities are all nice and safe like \nit was 20 years ago before you were born.");
        yearLabelNumber.setText("" + year);
        placeLabelName.setText(place);
        choice1.setText("Settle in Canada");
        choice2.setText("Go to Oregon");
        choice3.setText("Go South");
        choice4.setText("Prepare for space travel");
    }

    public void settledC() {
        position = "settledC";
        place = "Canada";
        year += 2;
        mainTextArea.setText("It is now " + year + ". You and your family have settled in Canada. \n" +
                "Those who survived managed to grow quickly. The prosperity of Canada \nbrought hope to rest of humanity. \n" +
                "Its influence begins to expand to its neighboring territories.\n\n \"In order to rise from its ashes,\n" +
                "A phoenix\n" +
                "First\n" +
                "Must\n" +
                "Burn\"");
        yearLabelNumber.setText("" + year);
        placeLabelName.setText(place);
        choice1.setText("Reform government");
        choice2.setText("Develop cure");
        choice3.setText("Prepare for space travel");
        choice4.setText("Explore other territories");
    }

    public void cure() {
        position = "cure";
        place = "World";
        year += 2;
        mainTextArea.setText("A cure has finally been developed, which will soon be disseminated across\nthe world. " +
                "Due to the lessened population, the climate is starting to recover\nand more places are becoming inhabitable again. " +
                "These survivors will set \nfoot again on territories that were once discovered but wiped out from \nhuman existence." +
                "\n\n\"The Self must create\nIts own reasons for being.\nTo shape God,\nShape self.\"");
        yearLabelNumber.setText("" + year);
        placeLabelName.setText(place);
        choice1.setText("Victory");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void victory() {
        playerPanel.setVisible(false);
        choiceButtonPanel.setVisible(false);
        mainTextPanel.setVisible(false);

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(20, 150, 750, 100);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("Congrats!!!");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        subtitleNamePanel = new JPanel();
        subtitleNamePanel.setBounds(86, 300, 600, 50);
        subtitleNamePanel.setBackground(Color.black);
        subtitleNameLabel = new JLabel("You have saved humanity.");
        subtitleNameLabel.setForeground(Color.white);
        subtitleNameLabel.setFont(normalFont);

        titleNamePanel.setVisible(true);
        subtitleNamePanel.setVisible(true);

        titleNamePanel.add(titleNameLabel);
        subtitleNamePanel.add(subtitleNameLabel);

        con.add(titleNamePanel);
        con.add(subtitleNamePanel);



    }



    public void createReligion() {
        position = "createReligion";
        year++;
        mainTextArea.setText("The year is now " + year + ". \nYou are living with your family in "+ place + ".\n" +
                "Your father found out about your own religion. He was furious and made you decide between starting " +
                "the religion and leaving the family. \n\n\"As a sermonizer, how am I going to make other people believe me if " +
                "my own daughter doesn't? You are such a disgrace to the family. You must \nchoose.\"");
        yearLabelNumber.setText("" + year);
        placeLabelName.setText(place);
        choice1.setText("Go back home");
        choice2.setText("Leave the family");
        choice3.setText("");
        choice4.setText("");
    }

    public void outInStreets() {
        position = "outInStreets";
        year++;
        mainTextArea.setText("The year is now " + year + ". \nYour family lives in "+ place + ".\n" +
                "You left the family to start your own religion Earthseed.\nLooking clean, you were quickly spotted " +
                " by a group of young criminals.\nYou were robbed of the only few bucks in your " +
                "pocket and are now out of any resource.");
        yearLabelNumber.setText("" + year);
        placeLabelName.setText(place);
        choice1.setText("Continue");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void streetDead() {
        position = "streetDead";
        place = "Los Angeles";
        year++;
        mainTextArea.setText("The year is now " + year + ". \nYou are out in the streets in "+ place + ".\n" +
                "You have run out of all resources. As you begin to starve, your hyperem-\npathy symptom becomes" +
                " even more apparent. Eventually, you die of \nimmense pain at the age of " + (year - 2009) + ".");
        yearLabelNumber.setText("" + year);
        placeLabelName.setText(place);
        choice1.setText("Exit");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }


    public class TitleScreenHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            createGameScreen();
        }
    }
    public class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();

            switch(position) {
                case "intro":
                    switch(yourChoice) {
                        case "c1": convince(); break;
                        case "c2": createReligion(); break;
                        case "c3": break;
                        case "c4": break;
                    }
                    break;
                case "convince":
                    switch(yourChoice) {
                        case "c1": convinced(); break;
                        case "c2": createReligion();
                        case "c3": break;
                        case "c4": break;
                    }
                    break;
                case "createReligion":
                    switch(yourChoice) {
                        case "c1": intro(); break;
                        case "c2": outInStreets();
                        case "c3": break;
                        case "c4": break;
                    }
                    break;
                case "outInStreets":
                    switch(yourChoice) {
                        case "c1": streetDead(); break;
                        case "c2": break;
                        case "c3": break;
                        case "c4": break;
                    }
                    break;
                case "convinced":
                    switch(yourChoice) {
                        case "c1": break;
                        case "c2": break;
                        case "c3": canada(); break;
                        case "c4": break;
                    }
                    break;
                case "canada":
                    switch(yourChoice) {
                        case "c1": settledC(); break;
                    }
                    break;
                case "settledC":
                    switch(yourChoice) {
                        case "c2": cure(); break;
                    }
                    break;
                case "cure":
                    switch(yourChoice) {
                        case "c1": victory(); break;
                    }
                    break;

            }
        }
    }
}

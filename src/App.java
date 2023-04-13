import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import java.util.Random;

public class App extends Application {

  //Initialize players array
  public static final Player[] playerList = new Player[4];
  public static final Property[] propertyList = new Property[22];
  public static final Utility[] utilityList = new Utility[2];
  public static final Railroad[] railroadList = new Railroad[4];
  public static final TaxSpace[] taxSpaces = new TaxSpace[2];
  public static final ChanceSpace[] chanceSpaces = new ChanceSpace[6];
  public static final JailSpace[] jailSpaces = new JailSpace[1];
  public winStatus winStatus;
  public static int turn;
  int playerRoll;
  int playerRoll2;
  int playerRoll3;
  int playerRoll4;
  int playerRoll5;
  int playerRoll6;
  int totalRoll;
  int playerPosition;
  int currentPosition;
  int chance;
  private int jailTurns;
  public static int boardSpace;
  private int bankruptPlayers;
  
  Random random = new Random();

  public void createProperties() {
    Property Mediterranean_Avenue = new Property(Color.Brown, Order.ONE);
    propertyList[0] = Mediterranean_Avenue;
    Mediterranean_Avenue.propertyName = "Mediterranean Avenue";
    Mediterranean_Avenue.propertyValue = 60;
    Mediterranean_Avenue.boardSpace = 1;
    
    Property Baltic_Avenue = new Property(Color.Brown, Order.ONE);
    propertyList[1] = Baltic_Avenue;
    Baltic_Avenue.propertyName = "Baltic Avenue";
    Baltic_Avenue.propertyValue = 60;
    Baltic_Avenue.boardSpace = 3;

    Property Oriental_Avenue = new Property(Color.Light_Blue, Order.ONE);
    propertyList[2] = Oriental_Avenue;
    Oriental_Avenue.propertyName = "Oriental Avenue";
    Oriental_Avenue.propertyValue = 100;
    Oriental_Avenue.boardSpace = 6;

    Property Vermont_Avenue = new Property(Color.Light_Blue, Order.ONE);
    propertyList[3] = Vermont_Avenue;
    Vermont_Avenue.propertyName = "Vermont Avenue";
    Vermont_Avenue.propertyValue = 100;
    Vermont_Avenue.boardSpace = 8;
    
    Property Connecticut_Avenue = new Property(Color.Light_Blue, Order.ONE);
    propertyList[4] = Connecticut_Avenue;
    Connecticut_Avenue.propertyName = "Connecticut Avenue";
    Connecticut_Avenue.propertyValue = 120;
    Connecticut_Avenue.boardSpace = 9;

    Property St_Charles_Place = new Property(Color.Pink, Order.ONE);
    propertyList[5] = St_Charles_Place;
    St_Charles_Place.propertyName = "St. Charles Place";
    St_Charles_Place.propertyValue = 140;
    St_Charles_Place.boardSpace = 11;

    Property States_Avenue = new Property(Color.Pink, Order.ONE);
    propertyList[6] = States_Avenue;
    States_Avenue.propertyName = "States Avenue";
    States_Avenue.propertyValue = 140;
    States_Avenue.boardSpace = 13;

    Property Virginia_Avenue = new Property(Color.Pink, Order.ONE);
    propertyList[7] = Virginia_Avenue;
    Virginia_Avenue.propertyName = "Virginia Avenue";
    Virginia_Avenue.propertyValue = 160;
    Virginia_Avenue.boardSpace = 14;

    Property St_James_Place = new Property(Color.Orange, Order.ONE);
    propertyList[8] = St_James_Place;
    St_James_Place.propertyName = "St. James Place";
    St_James_Place.propertyValue = 180;
    St_James_Place.boardSpace = 16;

    Property Tennessee_Avenue = new Property(Color.Orange, Order.ONE);
    propertyList[9] = Tennessee_Avenue;
    Tennessee_Avenue.propertyName = "Tennessee Avenue";
    Tennessee_Avenue.propertyValue = 180;
    Tennessee_Avenue.boardSpace = 18;

    Property New_York_Avenue = new Property(Color.Orange, Order.ONE);
    propertyList[10] = New_York_Avenue;
    New_York_Avenue.propertyName = "New York Avenue";
    New_York_Avenue.propertyValue = 200;
    New_York_Avenue.boardSpace = 19;

    Property Kentucky_Avenue = new Property(Color.Red, Order.ONE);
    propertyList[11] = Kentucky_Avenue;
    Kentucky_Avenue.propertyName = "Kentucky Avenue";
    Kentucky_Avenue.propertyValue = 220;
    Kentucky_Avenue.boardSpace = 21;

    Property Indiana_Avenue = new Property(Color.Red, Order.ONE);
    propertyList[12] = Indiana_Avenue;
    Indiana_Avenue.propertyName = "Indiana Avenue";
    Indiana_Avenue.propertyValue = 220;
    Indiana_Avenue.boardSpace = 23;

    Property Illinois_Avenue = new Property(Color.Red, Order.ONE);
    propertyList[13] = Illinois_Avenue;
    Illinois_Avenue.propertyName = "Illinois Avenue";
    Illinois_Avenue.propertyValue = 240;
    Illinois_Avenue.boardSpace = 24;

    Property Atlantic_Avenue = new Property(Color.Yellow, Order.ONE);
    propertyList[14] = Atlantic_Avenue;
    Atlantic_Avenue.propertyName = "Atlantic Avenue";
    Atlantic_Avenue.propertyValue = 260;
    Atlantic_Avenue.boardSpace = 26;

    Property Ventnor_Avenue = new Property(Color.Yellow, Order.ONE);
    propertyList[15] = Ventnor_Avenue;
    Ventnor_Avenue.propertyName = "Ventnor Avenue";
    Ventnor_Avenue.propertyValue = 260;
    Ventnor_Avenue.boardSpace = 27;

    Property Marvin_Gardens = new Property(Color.Yellow, Order.ONE);
    propertyList[16] = Marvin_Gardens;
    Marvin_Gardens.propertyName = "Marvin Gardens";
    Marvin_Gardens.propertyValue = 280;
    Marvin_Gardens.boardSpace = 29;

    Property Pacific_Avenue = new Property(Color.Green, Order.ONE);
    propertyList[17] = Pacific_Avenue;
    Pacific_Avenue.propertyName = "Pacific Avenue";
    Pacific_Avenue.propertyValue = 300;
    Pacific_Avenue.boardSpace = 31;

    Property North_Carolina_Avenue = new Property(Color.Green, Order.ONE);
    propertyList[18] = North_Carolina_Avenue;
    North_Carolina_Avenue.propertyName = "North Carolina Avenue";
    North_Carolina_Avenue.propertyValue = 300;
    North_Carolina_Avenue.boardSpace = 32;

    Property Pennsylvania_Avenue = new Property(Color.Green, Order.ONE);
    propertyList[19] = Pennsylvania_Avenue;
    Pennsylvania_Avenue.propertyName = "Pennsylvania Avenue";
    Pennsylvania_Avenue.propertyValue = 320;
    Pennsylvania_Avenue.boardSpace = 34;

    Property Park_Place = new Property(Color.Blue, Order.ONE);
    propertyList[20] = Park_Place;
    Park_Place.propertyName = "Park Place";
    Park_Place.propertyValue = 350;
    Park_Place.boardSpace = 37;

    Property Boardwalk = new Property(Color.Blue, Order.ONE);
    propertyList[21] = Boardwalk;
    Boardwalk.propertyName = "Boardwalk";
    Boardwalk.propertyValue = 400;
    Boardwalk.boardSpace = 39;
}

public void createUtilities(){
  //Create the utilities
  Utility Electric_Company = new Utility(Order.ONE);
  utilityList[0] = Electric_Company;
  Electric_Company.propertyName = "Electric Company";
  Electric_Company.propertyValue = 150;
  Electric_Company.boardSpace = 12;

  Utility Waterworks = new Utility(Order.TWO);
  utilityList[1] = Waterworks;
  Waterworks.propertyName = "Waterworks";
  Waterworks.propertyValue = 150;
  Waterworks.boardSpace = 28;
}

public void createRailroads(){
  Railroad Reading_Railroad = new Railroad(Order.ONE);
  railroadList[0] = Reading_Railroad;
  Reading_Railroad.propertyName = "Reading Railroad";
  Reading_Railroad.boardSpace = 5;
  Reading_Railroad.propertyValue = 200;

  Railroad Pennsylvania_Railroad = new Railroad(Order.ONE);
  railroadList[1] = Pennsylvania_Railroad;
  Pennsylvania_Railroad.propertyName = "Pennsylvania Railroad";
  Pennsylvania_Railroad.boardSpace = 15;
  Pennsylvania_Railroad.propertyValue = 200;

  Railroad BO_Railroad = new Railroad(Order.ONE);
  railroadList[2] = BO_Railroad;
  BO_Railroad.propertyName = "B. & O. Railroad";
  BO_Railroad.boardSpace = 25;
  BO_Railroad.propertyValue = 200;

  Railroad Short_Line = new Railroad(Order.ONE);
  railroadList[3] = Short_Line;
  Short_Line.propertyName = "Short Line";
  Short_Line.boardSpace = 35;
  Short_Line.propertyValue = 200;
}

public void createChanceSpaces(){
  ChanceSpace ChanceSpace_1 = new ChanceSpace();
  chanceSpaces[0] = ChanceSpace_1;
  ChanceSpace_1.boardSpace = 2;

  ChanceSpace ChanceSpace_2 = new ChanceSpace();
  chanceSpaces[1] = ChanceSpace_2;
  ChanceSpace_2.boardSpace = 7;

  ChanceSpace ChanceSpace_3 = new ChanceSpace();
  chanceSpaces[2] = ChanceSpace_2;
  ChanceSpace_3.boardSpace = 17;
  
  ChanceSpace ChanceSpace_4 = new ChanceSpace();
  chanceSpaces[3] = ChanceSpace_3;
  ChanceSpace_4.boardSpace = 22;

  ChanceSpace ChanceSpace_5 = new ChanceSpace();
  chanceSpaces[4] = ChanceSpace_5;
  ChanceSpace_5.boardSpace = 33;

  ChanceSpace ChanceSpace_6 = new ChanceSpace();
  chanceSpaces[5] = ChanceSpace_6;
  ChanceSpace_6.boardSpace = 36;
}

public void createTaxSpaces(){
  TaxSpace Income_Space = new TaxSpace();
  taxSpaces[0] = Income_Space;
  Income_Space.propertyName = "Income Tax";
  Income_Space.propertyValue = 200;
  Income_Space.boardSpace = 4;

  TaxSpace Luxury_Tax = new TaxSpace();
  taxSpaces[1] = Luxury_Tax;
  Luxury_Tax.propertyName = "Luxury Tax";
  Luxury_Tax.propertyValue = 100;
  Luxury_Tax.boardSpace = 38;
}

public void createPlayers(){
  //Create the players and properties
    Player player1 = new Player(Order.ONE);
    Player player2 = new Player(Order.TWO);
    Player player3 = new Player(Order.THREE);
    Player player4 = new Player(Order.FOUR);
    
    playerList[0] = player1;
    playerList[1] = player2;
    playerList[2] = player3;
    playerList[3] = player4;
    
    playerList[0].setWinType(winStatus.P1_WIN);
    playerList[1].setWinType(winStatus.P2_WIN);
    playerList[2].setWinType(winStatus.P3_WIN);
    playerList[3].setWinType(winStatus.P4_WIN);
    
    playerList[0].playerPosition = 0;
    playerList[1].playerPosition = 0;
    playerList[2].playerPosition = 0;
    playerList[3].playerPosition = 0;
}

  public void startGame(){
    createProperties();
    createUtilities();
    createRailroads();
    createChanceSpaces();
    createTaxSpaces();
    createPlayers();
    JailSpace jailSpace = new JailSpace();
    jailSpaces[0] = jailSpace;
    jailSpace.boardSpace = 30;
    turn = 0;
    winStatus = winStatus.ACTIVE;
    if (playerList[turn].money <= 0){
      System.out.println("Player " + playerList[turn].getPlayOrder() + " is bankrupt");
    } if (bankruptPlayers == 3){
      endGame();
    }
  }
  

  public int diceRoll(int i, int j){
    i = random.nextInt(1, 7);
    j = random.nextInt(1, 7);
    totalRoll = i + j;
    
    if (playerList[turn].money == 0){
      changeTurns();
    }
    return totalRoll;
}

public int movePlayer(){
  playerList[turn].playerPosition += totalRoll;
  boardSpace = playerList[turn].playerPosition;
  if (playerList[turn].playerPosition > 40){
    playerList[turn].playerPosition = playerList[turn].playerPosition - 40;
    playerList[turn].money += 200;
    
    System.out.println("Player " +playerList[turn].getPlayOrder()+ "'s money is now " + playerList[turn].money);
  } else if (playerList[turn].playerPosition == 40){
    playerList[turn].playerPosition = playerList[turn].playerPosition - 39;
  }
  return boardSpace;
  
}

  public int returnRoll(int i, int j){
    diceRoll(i, j);
    movePlayer();
    return currentPosition;
  }

  public void changeTurns(){
    
    turn = (turn + 1) % 4;
    System.out.println("It is now Player " + playerList[turn].getPlayOrder() + "'s turn.");
    System.out.println("Player " + playerList[turn].getPlayOrder() + "'s money is currently at $" + playerList[turn].money + ".");
      
      if (playerList[turn].money <= 0){
      playerList[turn].bankruptPlayer();
      playerList[turn].isBankrupt();
      System.out.println("Player " + playerList[turn].getPlayOrder() + " is bankrupt. ");
      bankruptPlayers++;
      System.out.println("It is now " + playerList[turn + 1].getPlayOrder() + "'s turn.");
      changeTurns();
      
       if (bankruptPlayers == 3){
        endGame();
    }

      if (playerList[turn].inJail() == true){
        System.out.println("Player " + playerList[turn].getPlayOrder() + " is in jail.");
        jailTurns++;
        System.out.println("It is now " + playerList[turn + 1].getPlayOrder() + "'s turn.");

        if (jailTurns == 3){
          jailTurns = 0;
          System.out.println("Player " + playerList[turn].getPlayOrder() + " is out of jail.");
        }
      }

      for (int i = 0; i < propertyList.length; ++i){
        propertyList[i].isOwned = false;
      }
    }
  }

  public void endGame(){
  String gameWinner;
  
    for (int j = 0; j < 4; ++j){
      if (playerList[j].money <= 0){
        winStatus = playerList[j].isWinner();
      }
    }

  switch (winStatus){
      case P1_WIN -> gameWinner = "Player 1 Wins";
      case P2_WIN -> gameWinner = "Player 2 Wins";
      case P3_WIN -> gameWinner = "Player 3 Wins";
      case P4_WIN -> gameWinner = "Player 4 Wins";
      default -> gameWinner = "Bankrupt";   
    }
  }

  @Override
  public void start(Stage primaryStage) throws Exception {

    

    //Create the board
    BorderPane borderPane = new BorderPane();
    Image image = new Image("file:Board.jpg");
    ImageView imageView = new ImageView(image);
    imageView.setFitHeight(750);
    imageView.setFitWidth(750);
    
    //Create a start button
    Stage startStage = new Stage();
    Pane startPane = new Pane();
    Button startBtn = new Button("Start a new game");
    startPane.getChildren().add(startBtn);

    Stage controlStage = new Stage();
    GridPane controlPane = new GridPane();
    Button rollBtn = new Button("Roll");
    Button buyBtn = new Button("Buy");
    Button dontBuy = new Button("Don't buy");
    controlPane.getChildren().add(rollBtn);
    controlPane.add(buyBtn, 0, 55);
    controlPane.add(dontBuy, 1, 55);
    buyBtn.setDisable(true);
    dontBuy.setDisable(true);
    
    Scene boardScene = new Scene(borderPane, 750, 750);
    Scene startScene = new Scene(startPane, 150, 150);
    Scene controlScene = new Scene(controlPane, 150, 150);
    primaryStage.setTitle("Monopoly");
    primaryStage.setScene(boardScene);
    primaryStage.show();
    startStage.setTitle("Start Button");
    startStage.setScene(startScene);
    startStage.show();
    controlStage.setTitle("Game Controls");
    controlStage.setScene(controlScene);
    controlStage.show();
    borderPane.setCenter(imageView);

    startBtn.setOnAction(e -> {
      startGame();
      playerList[0].money = 1500;
      playerList[1].money = 1500;
      playerList[2].money = 1500;
      playerList[3].money = 1500;
      System.out.println("It is Player " +playerList[turn].getPlayOrder()+ "'s turn");
      if (bankruptPlayers == 3){
        endGame();
      }
      });

    rollBtn.setOnAction(e -> {
      if (winStatus == winStatus.ACTIVE && bankruptPlayers < 3){
        returnRoll(playerRoll, playerRoll2);
        System.out.println("You rolled a " + totalRoll);
        System.out.println("You are on space " + playerList[turn].playerPosition);
        System.out.println();

        for (int i = 0; i < jailSpaces.length; ++i){
          if (playerList[turn].playerPosition == jailSpace[i].boardSpace){
            System.out.println("You're going to jail!");
            playerList[turn].jailPlayer();
            changeTurns();
          }
        }

        for (int i = 0; i < propertyList.length; ++i){
          if (playerList[turn].playerPosition == propertyList[i].boardSpace){
            System.out.println("You have landed on " +propertyList[i].propertyName+ ".");
            if (propertyList[i].isOwned == false && playerList[turn].money >= propertyList[i].propertyValue){
              System.out.println("It is not owned. Will you buy it?");
              System.out.println();
              rollBtn.setDisable(true);
              buyBtn.setDisable(false);
              dontBuy.setDisable(false);
            } else if (propertyList[i].isOwned == false && propertyList[i].propertyValue > playerList[turn].money){
              System.out.println("You cannot afford this property.");
              System.out.println();
              changeTurns();
            }

            if (propertyList[i].isOwned == true){
              System.out.println("It is owned by Player " + propertyList[i].propertyOwner + ". You must pay them $" +propertyList[i].propertyValue);
              playerList[turn].money -= propertyList[i].propertyValue;
              System.out.println("Player " + playerList[turn].getPlayOrder() + " now has " + playerList[turn].money);
              System.out.println();
              changeTurns();
            }

          }
        }

        for (int i = 0; i < utilityList.length; ++i){
          if (playerList[turn].playerPosition == utilityList[i].boardSpace){
            System.out.println("You have landed on " +utilityList[i].propertyName+ ".");
            if (utilityList[i].isOwned == false && playerList[turn].money >= utilityList[i].propertyValue){
              System.out.println("It is not owned. Will you buy it?");
              System.out.println();
              rollBtn.setDisable(true);
              buyBtn.setDisable(false);
              dontBuy.setDisable(false);
            } else if (utilityList[i].isOwned == false && utilityList[i].propertyValue > playerList[turn].money){
              System.out.println("You cannot afford this property.");
              System.out.println();
              changeTurns();
            }

            if (utilityList[i].isOwned == true){
              System.out.println("It is owned by Player " + utilityList[i].propertyOwner + ". You must pay them $" +utilityList[i].propertyValue);
              playerList[turn].money -= utilityList[i].propertyValue;
              System.out.println("Player " + playerList[turn].getPlayOrder() + " now has " + playerList[turn].money);
              System.out.println();
              changeTurns();
            }
          }
        }

        for (int i = 0; i < railroadList.length; ++i){
          if (playerList[turn].playerPosition == railroadList[i].boardSpace){
            System.out.println("You have landed on " +railroadList[i].propertyName+ ".");
            if (railroadList[i].isOwned == false && playerList[turn].money >= railroadList[i].propertyValue){
              System.out.println("It is not owned. Will you buy it?");
              System.out.println();
              rollBtn.setDisable(true);
              buyBtn.setDisable(false);
              dontBuy.setDisable(false);
            } else if (railroadList[i].isOwned == false && railroadList[i].propertyValue > playerList[turn].money){
              System.out.println("You cannot afford this property.");
              System.out.println();
              changeTurns();
            }

            if (railroadList[i].isOwned == true){
              System.out.println("It is owned by Player " + railroadList[i].propertyOwner + ". You must pay them $" +railroadList[i].propertyValue);
              playerList[turn].money -= railroadList[i].propertyValue;
              System.out.println("Player " + playerList[turn].getPlayOrder() + " now has " + playerList[turn].money);
              System.out.println();
              changeTurns();
            }
          }
        }

        for (int i = 0; i < taxSpaces.length; ++i){
          if (playerList[turn].playerPosition == taxSpaces[i].boardSpace){
            System.out.println("You've landed on a " + taxSpaces[i].propertyName + ". You must pay $" + taxSpaces[i].propertyValue + ".");
            playerList[turn].money -= taxSpaces[i].propertyValue;
            System.out.println("Player " + playerList[turn].getPlayOrder() + " now has $" + playerList[turn].money + ".");
            changeTurns();
          }
        }
        
        for (int i = 0; i < chanceSpaces.length; ++i){
          if (playerList[turn].playerPosition == chanceSpaces[i].boardSpace){
            System.out.println("You've landed on a chance/community space.");
            chance = random.nextInt(1, 5);
            if (chance == 1){
              System.out.println("You lose $100");
              playerList[turn].money -= 100;
              System.out.println("Player " + playerList[turn].getPlayOrder() + " now has $" + playerList[turn].money + ".");
              changeTurns();
            } else if (chance == 2){
              System.out.println("You earn $200");
              playerList[turn].money += 200;
              System.out.println("Player " + playerList[turn].getPlayOrder() + " now has $" + playerList[turn].money + ".");
              changeTurns();
            } else if (chance == 3){
              System.out.println("You lose $300");
              playerList[turn].money -= 300;
              System.out.println("Player " + playerList[turn].getPlayOrder() + " now has $" + playerList[turn].money + ".");
              changeTurns();
            } else if (chance == 4){
              System.out.println("You earn $400");
              playerList[turn].money += 400;
              System.out.println("Player " + playerList[turn].getPlayOrder() + " now has $" + playerList[turn].money + ".");
              changeTurns();
            }
          }
        }

        
        
        
        
      } else {
        System.out.println("The game has not been started.");
      }
    });

    

    buyBtn.setOnAction(e -> {
      for (int i = 0; i < propertyList.length; ++i){
        if (playerList[turn].playerPosition == propertyList[i].boardSpace){
          propertyList[i].isOwned = true;
          propertyList[i].propertyOwner = playerList[turn].getPlayOrder();
          playerList[turn].money -= propertyList[i].propertyValue;
          System.out.println("Property " + propertyList[i].propertyName + " is now owned by " +playerList[turn].getPlayOrder());
          System.out.println("Player " + playerList[turn].getPlayOrder() + "'s money is now $" + playerList[turn].money);
          playerList[turn].propertiesOwned++;
          System.out.println("Player " + playerList[turn].getPlayOrder() + " now owns " + playerList[turn].propertiesOwned + " properties.");
          buyBtn.setDisable(true);
          dontBuy.setDisable(true);
          rollBtn.setDisable(false);
          System.out.println();
          changeTurns();
          return;
        }
      }
      
      for (int i = 0; i < utilityList.length; ++i){
        if (playerList[turn].playerPosition == utilityList[i].boardSpace){
          utilityList[i].isOwned = true;
          utilityList[i].propertyOwner = playerList[turn].getPlayOrder();
          playerList[turn].money -= utilityList[i].propertyValue;
          System.out.println("Utility " + utilityList[i].propertyName + " is now owned by " +playerList[turn].getPlayOrder());
          System.out.println("Player " + playerList[turn].getPlayOrder() + "'s money is now $" + playerList[turn].money);
          playerList[turn].propertiesOwned++;
          System.out.println("Player " + playerList[turn].getPlayOrder() + " now owns " + playerList[turn].propertiesOwned + " properties.");
          System.out.println();
          buyBtn.setDisable(true);
          dontBuy.setDisable(true);
          rollBtn.setDisable(false);
          changeTurns();
          return;
        }
      }
      
      for (int i = 0; i < railroadList.length; ++i){
        if (playerList[turn].playerPosition == railroadList[i].boardSpace){
          railroadList[i].isOwned = true;
          railroadList[i].propertyOwner = playerList[turn].getPlayOrder();
          playerList[turn].money -= railroadList[i].propertyValue;
          System.out.println("Property " + railroadList[i].propertyName + " is now owned by " +playerList[turn].getPlayOrder());
          System.out.println("Player " + playerList[turn].getPlayOrder() + "'s money is now $" + playerList[turn].money);
          playerList[turn].propertiesOwned++;
          System.out.println("Player " + playerList[turn].getPlayOrder() + " now owns " + playerList[turn].propertiesOwned + " properties.");
          System.out.println();
          buyBtn.setDisable(true);
          dontBuy.setDisable(true);
          rollBtn.setDisable(false);
          changeTurns();
          return;
        }
      }
    });

    dontBuy.setOnAction(e -> {
      changeTurns();
    });

  }
  
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }

  
  
}
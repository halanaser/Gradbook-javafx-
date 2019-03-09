/*
###############################GRAD BOOk Program###############################
                               By: HALA ELSAFADI
*******************************************************************************
*******************************************************************************
 */
package gradbook;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author fuSe
 */
public class GradBook extends Application {

    static gradbook.Student[] student;
    static String courseNumber;
    static String instructorfname;
    static String instructorlname;
    static int NOStudent;
    static String msg = "";
    int x=0;

    @Override
    public void start(Stage primaryStage) {

        TextField t1=new TextField();
        TextField t2=new TextField();
        TextField t3=new TextField();

        HBox pane1 = new HBox(10);
        pane1.setPadding(new Insets(10, 10, 0, 23));
        pane1.getChildren().addAll(new Label("Course Number        "), t1);

        HBox pane2 = new HBox(10);
        pane2.setPadding(new Insets(10, 10, 0, 23));
        pane2.getChildren().addAll(new Label("Instructor First Name"), t2, new Label("Instructor Second Name"), t3);

        courseNumber=   t1.getText();
        instructorfname=t2.getText();
        instructorlname=t3.getText();
        
        HBox pane3 = new HBox(10);
        pane3.setPadding(new Insets(10, 10, 0, 23));
        TextField NOStudents = new TextField();
        pane3.getChildren().addAll(new Label("Student Number       "), NOStudents);
        
        Button addRecord = new Button("        Add Records        ");
        Button searchStudent = new Button("  Search Student By ID  ");
        Button searchStudent2 = new Button("Search Student By Name");
        Button displayClassStatistics = new Button("Display Class Statistics");
        Button displayAllStudents = new Button("    Display All Students  ");
        
//*************************************************************************************************************************
        addRecord.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 if (NOStudents.getText().isEmpty()) {
                    msg ="Enter Student ID";
                } else {
                    NOStudent = Integer.parseInt(NOStudents.getText());
                    student = new gradbook.Student[NOStudent];
                    for (int i = 0; i < NOStudent - 1; i++) {
                        student[i] = new gradbook.Student();
                    }

                    Stage addRecordStage = new Stage();
//                addRecordStage.initStyle(StageStyle.UTILITY);
                    TextField studentId = new TextField();
                    TextField studentFName = new TextField();
                    TextField studentLName = new TextField();
                    TextField grade1 = new TextField();
                    TextField grade2 = new TextField();
                    TextField grade3 = new TextField();
                    grade1.setPrefColumnCount(3);
                    grade2.setPrefColumnCount(3);
                    grade3.setPrefColumnCount(3);

                    HBox pane11 = new HBox(10);
                    pane11.setPadding(new Insets(20, 0, 0, 13));
                    pane11.getChildren().addAll(new Label("Student ID             "), studentId);

                    HBox pane22 = new HBox(10);
                    pane22.setPadding(new Insets(10, 0, 0, 13));
                    pane22.getChildren().addAll(new Label("Student First Name"), studentFName);

                    HBox pane33 = new HBox(10);
                    pane33.setPadding(new Insets(10, 0, 0, 13));
                    pane33.getChildren().addAll(new Label("Student Last Name "), studentLName);

                    HBox pane55 = new HBox(10);
                    pane55.setPadding(new Insets(15, 0, 0, 13));
                    pane55.getChildren().addAll(new Label("Student Grades:"), new Label("Grade1"), grade1, new Label("Grade2"), grade2, new Label("Grade3"), grade3);

                    HBox pane66 = new HBox(20);
                    Button addBtn = new Button  ("   Add   ");
                    Button closebtn = new Button("  Close  ");
                    Button clearbtn = new Button("  Clear  ");
                    x = NOStudent - 1;
                    addBtn.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            gradbook.Student newStudent = new gradbook.Student();
                            
                            student[x] = new gradbook.Student();
//                System.out.println(studentId.getText());
                            student[x].setID(Integer.parseInt(studentId.getText()));
                            student[x].setFName(studentFName.getText());
                            student[x].setLName(studentLName.getText());

                            student[x].setExameGrades(Integer.parseInt(grade1.getText()), 0);
                            student[x].setExameGrades(Integer.parseInt(grade2.getText()), 1);
                            student[x].setExameGrades(Integer.parseInt(grade3.getText()), 2);
                            msg = "\nThe final grade for   " + student[x].getFName() + "   " + student[x].getLName() + "    ID#  " + student[x].getID() + "   is :   " + student[x].getFinalGrade()+"\n";
                            x--;
                            pane66.setPadding(new Insets(20, 10, 0, 23));
                            pane66.getChildren().addAll(new Label(msg));

                           searchStudent.setDisable(false);searchStudent2.setDisable(false);
                           displayClassStatistics.setDisable(false);displayAllStudents.setDisable(false);

                        }
                    });
                    
                    closebtn.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {

                                    addRecordStage.hide();
                                }
                            });
                    
                    clearbtn.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    studentId.setText("");studentFName.setText("");studentLName.setText("");
                                    grade1.setText("");grade2.setText("");grade3.setText("");
                                }
                            });

                    HBox pane44 = new HBox(20);
                    pane44.setPadding(new Insets(20, 10, 0, 150));
                    pane44.getChildren().addAll(addBtn,closebtn,clearbtn);

                    VBox vbox11 = new VBox(5);
                    vbox11.getChildren().addAll(pane11, pane22, pane33, pane55, pane44, pane66);

                    Scene addRecordScene = new Scene(vbox11, 100, 150);

                    addRecordStage.setTitle("Add New Student");
                    addRecordStage.setWidth(500);
                    addRecordStage.setHeight(350);
                    addRecordStage.setScene(addRecordScene);
//                primaryStage.hide();
                    addRecordStage.show();
                }
            }
        });

//*************************************************************************************************************************        
        searchStudent.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage searchStudentStage = new Stage();
                
                Label enterStudent = new Label("Enter the ID of the student you want to display (ex: 11):");
                TextField studentId = new TextField();
                HBox pane66 = new HBox(10);
                
                Button okbtn = new Button   ("  Search  ");
                Button closebtn = new Button("   Close  ");
                   
                okbtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                         msg="";
                        if (studentId.getText().isEmpty()) {
                            msg ="ERROR: Enter Student ID";
                        } else {
                            
                            int studentid = Integer.parseInt(studentId.getText());
                            if (student.length > 0) {
                                for (int i = 0; i < student.length; i++) {
                                    System.err.println(student[i].getID());
                                    if (student[i].getID() == studentid && i < student.length) {
                                        msg = "The student record for ID# " + studentid + " is " + student[i].getFName() + " " + student[i].getLName();
                                        break;
                                    } else if (student[i].getID() != studentid && i == student.length) {
                                        msg = "ERROR: there is no record for student ID # " + studentid + ".";
                                    }
                                }
                           
                            } else {
                                msg="ERROR: No Student in the class";
                            }
                       
                pane66.setPadding(new Insets(10, 0, 0, 13));
                pane66.getChildren().addAll(new Label(msg));
                        }
                            
                    }
                });
                
                closebtn.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    searchStudentStage.hide();
                                }
                            });
                         
                HBox pane11 = new HBox(10);
                pane11.setPadding(new Insets(20, 0, 0, 13));
                pane11.getChildren().addAll(enterStudent);

                HBox pane12 = new HBox(10);
                pane12.setPadding(new Insets(20, 0, 0, 23));
                pane12.getChildren().addAll(new Label("        Student ID  "), studentId);

                HBox pane13 = new HBox(10);
                pane13.setPadding(new Insets(20, 0, 0, 123));
                pane13.getChildren().addAll(okbtn,closebtn);

                VBox vbox11 = new VBox(10);
                vbox11.getChildren().addAll(pane11, pane12, pane13,pane66);

                Scene searchStudentScene = new Scene(vbox11, 100, 150);

                searchStudentStage.setTitle("Search Student By Id");
                searchStudentStage.setWidth(400);
                searchStudentStage.setHeight(300);
                searchStudentStage.setScene(searchStudentScene);
                searchStudentStage.show();

            }
        });
       
//*************************************************************************************************************************
        searchStudent2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage searchStudentStage = new Stage();
                Label enterStudent = new Label("Please enter the first name and last name of student you went:-");
                TextField studentFN = new TextField();
                TextField studentLN = new TextField();
                 HBox pane4 = new HBox(15);

                Button okbtn = new Button(" Search  ");
                Button closebtn = new Button("Close");
                okbtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                         msg="";
                        if (studentLN.getText().isEmpty() || studentFN.getText().isEmpty()) {
                            System.out.println("error");
                        } else if (student.length <= 0) {
                            System.out.println("error");
                        } else {
                            for (int i = 0; i < student.length; i++) {
                                if (((student[i].getFName()).equals(studentFN.getText())) && ((student[i].getLName()).equals(studentLN.getText())) && (i <= student.length)) {
                                    msg = "The student " + student[i].getFName() + " " + student[i].getLName() + " is found";
                                    break;
                                } else if ((!(student[i].getFName()).equals(studentFN.getText())) && (!(student[i].getLName()).equals(studentLN.getText())) && (i == student.length)) {
                                    msg = "Error! The Student you enter not fund \"the studend isn't record\"";
                                }
                            }
                            
                pane4.setPadding(new Insets(10, 0, 0, 13));
                pane4.getChildren().addAll(new Label(msg));
                        }
                    }
                });
                
                 closebtn.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    searchStudentStage.hide();
                                }
                            });
                HBox pane1 = new HBox(15);
                pane1.setPadding(new Insets(15, 0, 0, 13));
                pane1.getChildren().addAll(new Label("First Name"), studentFN);

                HBox pane2 = new HBox(15);
                pane2.setPadding(new Insets(15, 0, 0, 13));
                pane2.getChildren().addAll(new Label("Last Name"), studentLN);

                HBox pane3 = new HBox(15);
                pane3.setPadding(new Insets(15, 0, 0, 13));
                pane3.getChildren().addAll(okbtn,closebtn);

                VBox vbox11 = new VBox(20);
                vbox11.getChildren().addAll(pane1, pane2, pane3,pane4);

                Scene searchStudentScene = new Scene(vbox11, 100, 150);

                searchStudentStage.setTitle("Search Student By Name");
                searchStudentStage.setWidth(400);
                searchStudentStage.setHeight(300);
                searchStudentStage.setScene(searchStudentScene);
                searchStudentStage.show();

            }
        });
//*************************************************************************************************************************    
        displayClassStatistics.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage displayClassStatisticsStage = new Stage();
                
        Label l1=new Label("Statistical Results of "+ courseNumber + " (Instructor:" + instructorfname + " " + instructorlname);
        if (student.length>0){
        Label l2=new Label("Total number of student records:" +student.length);
        
        double avg = 0,highestScore=0, totalScore=0,lowestScore=0,
         totalAGrade=0,totalBGrade=0 ,totalCGrade=0,totalDGrade=0,totalEGrade=0;
        
        for (int i = 0; i < student.length; i++) {
            totalScore +=student[i].finalGrade;
            avg = totalScore/NOStudent;
            
            double next_index_finalGrade=student[++i].finalGrade;
            if(student[i].finalGrade>next_index_finalGrade)
                highestScore=student[i].finalGrade;
            else
                highestScore=next_index_finalGrade;
            
            if(student[i].finalGrade<next_index_finalGrade)
                lowestScore=student[i].finalGrade;
            else
                lowestScore=next_index_finalGrade;
            
            if(student[i].finalGrade>=90)
                totalAGrade+= student[i].finalGrade;
            if(student[i].finalGrade>=80)
                totalBGrade+= student[i].finalGrade;
            if(student[i].finalGrade>=70)
                totalCGrade+= student[i].finalGrade;
            if(student[i].finalGrade>=60)
                totalDGrade+= student[i].finalGrade;
            else  totalEGrade+= student[i].finalGrade;
            
        }
        int a = 0,b,c,d,e;
        totalAGrade=totalAGrade/NOStudent;
        if (totalAGrade==0) a=0; else a=1;
        
        totalBGrade=totalBGrade/NOStudent;
        if (totalBGrade==0) b=0; else b=1;
        
        totalCGrade=totalCGrade/NOStudent;
        if (totalCGrade==0) c=0; else c=1;
        
        totalDGrade=totalDGrade/NOStudent;
        if (totalDGrade==0) d=0; else d=1;
        
        totalEGrade=totalEGrade/NOStudent;
        if (totalEGrade==0) e=0; else e=1;
        
        Label msg1=new Label("Average Score: "+avg);
        Label msg2=new Label("Highest Score: "+highestScore);
        Label msg3=new Label("Lowest Score: "+lowestScore);
        Label msg4=new Label("Total 'A' Grades: "+a+ "( " +totalAGrade+" of class)");
        Label msg5=new Label("Total 'B' Grades: "+b+ "( " +totalBGrade+" of class)");
        Label msg6=new Label("Total 'C' Grades: "+c+ "( " +totalCGrade+" of class)");
        Label msg7=new Label("Total 'D' Grades: "+d+ "( " +totalDGrade+" of class)");
        Label msg8=new Label("Total 'E' Grades: "+e+ "( " +totalEGrade+" of class)");
       
         
        HBox pane1 = new HBox(10);
        pane1.setPadding(new Insets(10, 0, 0, 13));
        pane1.getChildren().addAll(l1);
        
         HBox pane2 = new HBox(10);
        pane2.setPadding(new Insets(10, 0, 0, 13));
        pane2.getChildren().addAll(l2);
        
         HBox pane3 = new HBox(10);
        pane3.setPadding(new Insets(10, 0, 0, 13));
        pane3.getChildren().addAll(msg1);
        
         HBox pane4 = new HBox(10);
        pane4.setPadding(new Insets(10, 0, 0, 13));
        pane4.getChildren().addAll(msg2,msg3);
//        
//        HBox pane5 = new HBox(10);
//        pane5.setPadding(new Insets(10, 0, 0, 13));
//        pane5.getChildren().addAll(msg3);
        
        HBox pane6 = new HBox(10);
        pane6.setPadding(new Insets(10, 0, 0, 13));
        pane6.getChildren().addAll(msg4,msg5);
        
        HBox pane7 = new HBox(10);
        pane7.setPadding(new Insets(10, 0, 0, 13));
        pane7.getChildren().addAll(msg6,msg7);
        
        HBox pane8 = new HBox(10);
        pane8.setPadding(new Insets(10, 0, 0, 13));
        pane8.getChildren().addAll(msg8);
        
         
        Button closebtn = new Button("Close");
         closebtn.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    displayClassStatisticsStage.hide();
                                }
                            });
                
          HBox pane9 = new HBox(10);
        pane9.setPadding(new Insets(10, 0, 0, 13));
        pane9.getChildren().addAll(closebtn);

        VBox vbox11 = new VBox(10);
        vbox11.getChildren().addAll(pane1,pane2,pane3,pane4,pane6,pane7,pane8,pane9);

        Scene displayClassStatisticsStageScene = new Scene(vbox11, 100, 150);

        displayClassStatisticsStage.setTitle("Display Class Statistics");
        displayClassStatisticsStage.setWidth(400);
        displayClassStatisticsStage.setHeight(400);
        displayClassStatisticsStage.setScene(displayClassStatisticsStageScene);
        displayClassStatisticsStage.show();
        }}
        });
//*************************************************************************************************************************
        
        displayAllStudents.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage displayAllStudentsStage = new Stage();

                
         Label l1=new Label("***Class Roster and Grade Sheet***");
//         Label l2 = null;Label l3 = null;Label l4= null;Label l5= null;Label l6= null;Label l7= null;
        if(student.length<=0)System.out.println("Error: There is no students in this course");
        else
        for (int i = 0; i < student.length; i++) {
            System.out.println(student[i].getFName());
             Label l2=new Label("Student record for : " + student[i].getFName() + " " + student[i].getLName() + " ID# " + student[i].getID() + "): ");
             Label l3=new Label("   Exame1: " + student[i].getExamGrades(0));
             Label l4=new Label("   Exame2: " + student[i].getExamGrades(1));
             Label l5=new Label("   finalExame1: " + student[i].getExamGrades(2));
             Label l6=new Label("   Final Grades : " + student[i].getFinalGrade());
             Label l7=new Label("   letter Grades :" + student[i].getLetterGrade());
            
                        

            HBox pane1 = new HBox(10);
            pane1.setPadding(new Insets(i+10, 0, 0, 13));
            pane1.getChildren().addAll(l1);

            HBox pane2 = new HBox(10);
            pane2.setPadding(new Insets(i+10, 0, 0, 13));
            pane2.getChildren().addAll(l2);

            HBox pane3 = new HBox(10);
            pane3.setPadding(new Insets(i+10, 0, 0, 13));
            pane3.getChildren().addAll(l3,l4);

            HBox pane4 = new HBox(10);
            pane4.setPadding(new Insets(i+10, 0, 0, 13));
            pane4.getChildren().addAll(l5,l6,l7);
        
                 Button closebtn = new Button("Close");
         closebtn.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    displayAllStudentsStage.hide();
                                }
                            });
                
          HBox pane9 = new HBox(10);
        pane9.setPadding(new Insets(10, 0, 0, 13));
        pane9.getChildren().addAll(closebtn);
        
                VBox vbox11 = new VBox(10);
                vbox11.getChildren().addAll(pane1,pane2,pane3,pane4,pane9);
        
                Scene displayAllStudentsScene = new Scene(vbox11, 100, 150);
        
                displayAllStudentsStage.setTitle("Display All Students");
                displayAllStudentsStage.setWidth(400);
                displayAllStudentsStage.setHeight(300);
                displayAllStudentsStage.setScene(displayAllStudentsScene);
        } displayAllStudentsStage.show();
        }
        });
//*************************************************************************************************************************
        Button exit = new Button("             Exit         ");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });
        
// ***********************************************************************************************************************       
       searchStudent.setDisable(true);searchStudent2.setDisable(true);
       displayClassStatistics.setDisable(true);displayAllStudents.setDisable(true);
        HBox pane4 = new HBox(20);
        pane4.setPadding(new Insets(15, 0, 0, 100));
        pane4.getChildren().addAll(addRecord, searchStudent, searchStudent2);

        HBox pane5 = new HBox(20);
        pane5.setPadding(new Insets(15, 0, 0, 100));
        pane5.getChildren().addAll(displayClassStatistics, displayAllStudents, exit);

        HBox pane6 = new HBox(10);
        pane6.setPadding(new Insets(10, 0, 0, 13));
        pane6.getChildren().addAll(new Label(msg));

        HBox pane = new HBox(10);
        pane.setPadding(new Insets(20, 10, 10, 220));
        pane.getChildren().addAll(new Label("***********************************************"
                                    +'\n' + "                Hello In My Program              "+'\n'+
                                            "                     GRAD BOOK                   "+'\n'
                                          + "***********************************************"));
        
        VBox vbox = new VBox(15);
        vbox.getChildren().addAll(pane,pane1, pane2, pane3, pane4, pane5, pane6);

        Scene scene = new Scene(vbox, 120, 170);

        primaryStage.setTitle("Grade Book");
        primaryStage.setWidth(700);
        primaryStage.setHeight(450);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
//**********END************
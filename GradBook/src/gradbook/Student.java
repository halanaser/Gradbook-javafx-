/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradbook;

/**
 *
 * @author Hala
 */
public class Student {
   String fName="";
   String lName="";
   int ID;
   int []examGrades= new int[3];
   double finalGrade;
   char letterGrade;
   int numOfStudent;
   String student;
   
   public Student(){
      
   }
   public Student(String student){
       this.student = student;
   }

   
   public String getFName(){
   return fName;
   }
   
   public String getLName(){
   return lName;
   }
   
   public int getID(){
//       System.out.println(ID);
   return ID;
   }
   
   public double getFinalGrade(){
       calculateFinalGrade( );
   return finalGrade;
   }
   public double getExamGrades(int index){
   return examGrades[index];
   }
   
   public char getLetterGrade(){
       calculateLetterGrade();
   return letterGrade;
   }
   
   public int getNumOfStudent(){
   return numOfStudent;
   }
   
   public void setFName( String f_Name ) {
      fName = f_Name;
   }
   
    public void setLName( String l_Name ) {
      lName = l_Name;
   }
   
    public void setID( int id ) {
      ID = id;
   }
    
   public void setExameGrades( int ExameGrade, int index ) {
      
      examGrades[index]=ExameGrade;
   }
   
   public void calculateFinalGrade() {
   
    finalGrade= examGrades[0]*(0.3) + examGrades[1]*(0.3) + examGrades[2]*(0.4);

   }
   
    public void calculateLetterGrade() {
//     int   finalGrade_int=(int)finalGrade;
//      letterGrade = (char)finalGrade_int ;
        if(finalGrade>=90)letterGrade='A';
        else if(finalGrade>=80)letterGrade='B';
        else if(finalGrade>=70)letterGrade='C';
        else if(finalGrade>=60)letterGrade='D';
        else letterGrade='F';
        
        
        
   }
   
   
   
}

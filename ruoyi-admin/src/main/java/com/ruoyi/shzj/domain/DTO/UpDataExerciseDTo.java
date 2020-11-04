package com.ruoyi.shzj.domain.DTO;

public class UpDataExerciseDTo {
   private String subject;
   private String choiceA;
   private String choiceB;
   private String choiceC;
   private String choiceD;
   private String answer;

   @Override
   public String toString() {
      return "UpDataExerciseDTo{" +
              "subject='" + subject + '\'' +
              ", choiceA='" + choiceA + '\'' +
              ", choiceB='" + choiceB + '\'' +
              ", choiceC='" + choiceC + '\'' +
              ", choiceD='" + choiceD + '\'' +
              ", answer='" + answer + '\'' +
              '}';
   }

   public String getSubject() {
      return subject;
   }

   public void setSubject(String subject) {
      this.subject = subject;
   }

   public String getChoiceA() {
      return choiceA;
   }

   public void setChoiceA(String choiceA) {
      this.choiceA = choiceA;
   }

   public String getChoiceB() {
      return choiceB;
   }

   public void setChoiceB(String choiceB) {
      this.choiceB = choiceB;
   }

   public String getChoiceC() {
      return choiceC;
   }

   public void setChoiceC(String choiceC) {
      this.choiceC = choiceC;
   }

   public String getChoiceD() {
      return choiceD;
   }

   public void setChoiceD(String choiceD) {
      this.choiceD = choiceD;
   }

   public String getAnswer() {
      return answer;
   }

   public void setAnswer(String answer) {
      this.answer = answer;
   }

}

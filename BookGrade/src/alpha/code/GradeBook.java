package alpha.code;

import java.util.ArrayList;

import java.util.Scanner;

public class GradeBook {

    ArrayList<String> studentName = new ArrayList<>(); //array list for students names
    ArrayList<Double> studentScore = new ArrayList<>(); //array list for student score

    //performs various operations on the data
    public void processData(){
        init();

        //output average
        System.out.printf("Average: %.2f%n", getAverage());

        //output the smallest score
        System.out.printf("Least score: %.2f%n", getMinimum());

        //output the highest score
        System.out.printf("Highest score: %.2f%n", getMaximum());

        outPutBarChart();

    }

    //out put the grade distribution
    public void outPutBarChart(){
        System.out.println();

        //output heading
        System.out.println("Grade Distribution Table");
        double[] freq = new double[11];//initialize an array of size 11

        for(double grade : studentScore){ //Loops through every grade in the studentScore array.
            ++freq[(int) (grade/10)];
            //System.out.printf("Frequency: %s%n", Arrays.toString(freq));
        }

        for(int i=0; i< freq.length; i++){
            if(i == 10) {
                System.out.printf("%5d: ", 100);
            }
            else
                System.out.printf("%02d-%02d: ",
                        i*10, (i*10) + 9);

            //prints asteriks
            for (int star =0; star<freq[i]; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void init(){
        Scanner sc = new Scanner(System.in); //instantiates Scanner

        System.out.println("Enter total number of students");
        int studentTotal = sc.nextInt();//prompts user for total number of students

        if(studentTotal == 0){//validates the value of studentTotal
            System.out.println("Zero number of students entered.");
            System.out.println();
            return;
        }else
            for(int i=0; i<studentTotal;i++){
                System.out.println("Student " + (i+1));

                System.out.print("Enter student name:");
                String name = sc.next();

                System.out.println("Enter "+ name.toUpperCase() + "'s score");
                double score = sc.nextDouble();


                studentName.add(name.toUpperCase());
                studentScore.add(score);
            }

        System.out.println("===== STUDENT GRADE BOOK =====");
        System.out.printf("%10s %9s%n","NAME","SCORE" );
        for (int i=0; i<studentName.size(); i++){
            System.out.printf("%d%9s:    %.2f%n", i+1, studentName.get(i), studentScore.get(i));
        }

        sc.close();
    }

    //determines the minimum grade
    public double  getMinimum(){
        if(!studentScore.isEmpty()){
            double max = studentScore.get(0);//assumes first element to be the largest
            for(double score : studentScore){
                if(max > score)
                    max = score;

            }
            return max;
        }
        return 0.00;
    }

    //determines the maximum grade
    public double  getMaximum(){
        if(!studentScore.isEmpty()){
            double max = studentScore.get(0);//assumes first element to be the largest
            for(double score : studentScore){
                if(max < score)
                    max = score;

            }
            return max;
        }
        return 0.00;
    }

    //determines average.
    public double getAverage() {
        double total;
        if (!studentName.isEmpty()) {
            total = 0;
            for (double grade : studentScore) {
                total += grade; //sums all the scores
            }
            return (total / studentScore.size());
        }
        return 0.00;
    }


}

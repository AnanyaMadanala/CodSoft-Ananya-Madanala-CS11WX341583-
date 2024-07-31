import java.util.Scanner;
public class StudentGradeCalculator {
    public static void main(String[] args) 
    {
	Scanner scanner= new Scanner(System.in);
	System.out.println("Enter no of subjects=");
	int noOfSubjects=scanner.nextInt();
	int totalMarks=0;
        char grade;
	for(int i=1;i<=noOfSubjects;i++)
	{
	    System.out.println("Enter marks for the subjects "+i+" out of(100):");
	    int marks=scanner.nextInt();
	    totalMarks+=marks;
	}
	double avgpercentage=(double) totalMarks/noOfSubjects;
	if(avgpercentage>=80)
	{
	    grade='A';
	}
	else if(avgpercentage>60)
	{
	    grade='B';
	}
	else if(avgpercentage>40)
	{
	    grade='C';
	}
	else if(avgpercentage>33)
	{
	    grade='D';
	}
	else
	{
	    grade='F';
	}
	System.out.println("\nTotal marks of all subjects="+totalMarks+"\nAverage percentage of all subjects="+avgpercentage+"\nGrade obtained="+grade);
	scanner.close();
    }
}

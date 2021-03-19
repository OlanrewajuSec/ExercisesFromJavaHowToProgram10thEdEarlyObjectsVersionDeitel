package GradeBook;

public class MulidimensionalGradeBook {
    private String courseName;
    private int[][] grades;

    public MulidimensionalGradeBook(String courseName, int[][] grades) {
        this.courseName = courseName;
        this.grades = grades;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void processGrades() {
        outputGrades();

        System.out.printf("%n%s %d%n%s %d%n%n",
                "Lowest grade in the grade book is", getMinimum(),
                "Highest grade in the grade book is", getMaximum());

        outputBarChart();
    }

    public int getMinimum() {
        int lowGrade = grades[0][0];

        for (int[] studenGrades : grades) {
            for (int grade : studenGrades) {
                if (grade < lowGrade) {
                    lowGrade = grade;
                }
            }
        }
        return lowGrade;
    }

    public int getMaximum() {
        int highGrade = grades[0][0];

        for (int[] studenGrades : grades) {
            for (int grade : studenGrades) {
                if (grade > highGrade) {
                    highGrade = grade;
                }
            }
        }
        return highGrade;
    }

    public double getAverage(int[] grades) {
        int total = 0;

        for (int grade : grades) {
            total += grade;
        }

        return (double) total / grades.length;
    }

    public void outputBarChart() {
        int[] frequency = new int[11];

        for (int[] grade : grades) {
            for (int grades : grade) {
                ++frequency[grades / 10];
            }
        }

        for (int count = 0; count < frequency.length; count++) {
            if (count == 10) {
                System.out.printf("%5d: ", 100);
            } else {
                System.out.printf("%02d-%02d: ",
                        count * 10, count * 10 + 9);
            }

            for (int stars = 0; stars < frequency[count];) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public void outputGrades() {
        System.out.printf("The grades are:%n%n");
        System.out.print("          ");

        for (int test = 0; test < grades[0].length; test++) {
            System.out.printf("Test %d ", test + 1);
        }

        System.out.println("Average");

        for (int student = 0; student < grades.length; student++) {
            System.out.printf("Student %2d", student + 1);

            for (int test : grades[student]) {
                System.out.printf("%8d", test);
            }

            double average = getAverage(grades[student]);

            System.out.printf("%9.2f%n", average);
        }
    }
}

package programming2;

public class Lab1_1 {

    public static void main(String[] args) {
        char[] key = {'D', 'B', 'D', 'C', 'C', 'D'};
        char[][] answers = {
            {'A', 'B', 'A', 'C', 'C', 'D'},
            {'D', 'B', 'A', 'B', 'C', 'A'},
            {'E', 'D', 'D', 'A', 'C', 'B'},
            {'C', 'B', 'A', 'E', 'D', 'C'}};
        for (int students = 0; students < answers.length; students++) {
            int counter = 0;
            for (int questions = 0; questions < answers[0].length; questions++) {
                if (answers[students][questions]==(key[questions])) {
                    counter++;
                }
            }
            System.out.println("Student " + students + "'s correct count is " + counter + " out of 6");

        }

    }

}



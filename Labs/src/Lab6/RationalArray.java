
public class RationalArray {

    public static void main(String[] args) {

        RationalNumber[] List1 = new RationalNumber[3];
        RationalNumber[] List2 = new RationalNumber[3];
        RationalNumber[] AddList = new RationalNumber[3];
        RationalNumber[] MultiList = new RationalNumber[3];

        List1[0] = new RationalNumber(3, 4);
        List1[1] = new RationalNumber(1, 3);
        List1[2] = new RationalNumber(1, 2);

        List2[0] = new RationalNumber(2, 5);
        List2[1] = new RationalNumber(1, 4);
        List2[2] = new RationalNumber(3, 5);

        for (int i = 0; i < 3; i++) {
            AddList[i] = List1[i].add(List2[i]);
            MultiList[i] = List1[i].multiply(List2[i]);
        }

        System.out.printf("%-7s %-7s %-7s %-7s\n", "LIST1", "LIST2", "ADD", "MULTIPLY");
        for (int i = 0; i < 3; i++) {
            System.out.printf("%-7s %-7s %-7s %-7s\n", List1[i].toString(), List2[i].toString(), AddList[i].toString(), MultiList[i].toString());
        }

    }

}


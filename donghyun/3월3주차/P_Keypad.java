class Soultion {

    class hand {
        int x;
        int y;

        hand(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public String solution(int[] numbers, String hand) {
        hand[] button = new hand[13];
        button[1] = new hand(1, 1);
        button[2] = new hand(2, 1);
        button[3] = new hand(3, 1);
        button[4] = new hand(1, 2);
        button[5] = new hand(2, 2);
        button[6] = new hand(3, 2);
        button[7] = new hand(1, 3);
        button[8] = new hand(2, 3);
        button[9] = new hand(3, 3);
        button[0] = new hand(2, 4);
        button[11] = new hand(1, 4);
        button[12] = new hand(3, 4);

        hand left = button[11];
        hand right = button[12];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            switch (numbers[i]) {

                case 1:
                case 4:
                case 7:
                    sb.append("L");
                    left = button[numbers[i]];
                    break;

                case 3:
                case 6:
                case 9:
                    sb.append("R");
                    right = button[numbers[i]];
                    break;

                case 2:
                case 5:
                case 8:
                case 0:
                    int left_dst = Math.abs(left.x - button[numbers[i]].x) + Math.abs(left.y - button[numbers[i]].y);
                    int right_dst = Math.abs(right.x - button[numbers[i]].x) + Math.abs(right.y - button[numbers[i]].y);

                    if (left_dst < right_dst) {
                        left = button[numbers[i]];
                        sb.append("L");
                    } else if (left_dst > right_dst) {
                        right = button[numbers[i]];
                        sb.append("R");
                    } else {
                        if (hand.equals("right")) {
                            right = button[numbers[i]];
                            sb.append("R");
                        } else {
                            left = button[numbers[i]];
                            sb.append("L");
                        }
                    }
                    break;
            }
        }

        String answer = sb.toString();
        return answer;
    }
}

public class P_Keypad {
    public static void main(String[] args) {
        Soultion answers = new Soultion();
        int[] numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
        String hand = "right";
        answers.solution(numbers, hand);
    }
}

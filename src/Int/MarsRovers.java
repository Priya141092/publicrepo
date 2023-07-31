package Int;

import java.util.Scanner;

class MarsRovers {
    private int x;
    private int y;
    private char direction;

    public MarsRovers(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void processInstructions(String instructions) {
        for (char instruction : instructions.toCharArray()) {
            if (instruction == 'L') {
                turnLeft();
            } else if (instruction == 'R') {
                turnRight();
            } else if (instruction == 'M') {
                move();
            }
        }
    }

    private void turnLeft() {
        switch (direction) {
            case 'N':
                direction = 'W';
                break;
            case 'W':
                direction = 'S';
                break;
            case 'S':
                direction = 'E';
                break;
            case 'E':
                direction = 'N';
                break;
        }
    }

    private void turnRight() {
        switch (direction) {
            case 'N':
                direction = 'E';
                break;
            case 'E':
                direction = 'S';
                break;
            case 'S':
                direction = 'W';
                break;
            case 'W':
                direction = 'N';
                break;
        }
    }

    private void move() {
        switch (direction) {
            case 'N':
                y++;
                break;
            case 'E':
                x++;
                break;
            case 'S':
                y--;
                break;
            case 'W':
                x--;
                break;
        }
    }

    public String getPosition() {
        return x + " " + y + " " + direction;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read plateau coordinates
        int plateauX = scanner.nextInt();
        int plateauY = scanner.nextInt();

        // Read new line to consume the rest of the line
        scanner.nextLine();

        // Read rover information and process instructions
        while (scanner.hasNextLine()) {
            int roverX = scanner.nextInt();
            int roverY = scanner.nextInt();
            char roverDirection = scanner.next().charAt(0);
            scanner.nextLine(); // Consume new line

            MarsRovers rover = new MarsRovers(roverX, roverY, roverDirection);
            String instructions = scanner.nextLine();
            rover.processInstructions(instructions);

            System.out.println(rover.getPosition());
        }

        scanner.close();
    }
}

package frc.birdie;

public class toggleMove {
    private static boolean beak = true;
    private static boolean head = true;
    private static boolean backPistons = false;
    private static boolean frontPistons = false;
    private static boolean compressor = true;

    public static void toggle(String component) {
        switch (component) {
            case "beak":
                toggleMove.beak();
                break;
            case "head":
                toggleMove.head();
                break;
            case "frontPistons":
                toggleMove.frontPistons();
                break;
            case "backPistons":
                toggleMove.backPistons();
                break;
            case "compressor":
                toggleMove.compressor();
                break;

        }
    }

    private static void beak() {
        if (beak) {
            components.beakClose.startPulse();
            beak = false;
        } else if (!beak) {
            components.beakOpen.startPulse();
            beak = true;
        }
    }

    private static void head() {
        if (head) {
            components.headFlatten .startPulse();
            head = false;
        } else if (!head) {
            components.headExtend.startPulse();
            head = true;
        }
    }

    private static void frontPistons() {
        if (frontPistons) {
            components.pistonsFront.set(true);
            frontPistons = false;
        } else if (!frontPistons) {
            components.pistonsFront.set(false);
            frontPistons = true;
        }
    }

    private static void backPistons() {
        if (backPistons) {
            components.pistonsBack.set(true);
            backPistons = false;
        } else if (!backPistons) {
            components.pistonsBack.set(false);
            backPistons = true;
        }
    }

    private static void compressor() {
        if (compressor) {
            components.compressor.start();
            compressor = false;
        } else if (!compressor) {
            components.compressor.stop();
            compressor = true;  
        }
    }
}
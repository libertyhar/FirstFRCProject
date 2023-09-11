package frc.trigon.robot.subsystems.differentialdrive;


import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.function.Supplier;

public class DifferentialDrive extends SubsystemBase {
    private final static DifferentialDrive INSTANCE = new DifferentialDrive();
    edu.wpi.first.wpilibj.drive.DifferentialDrive myDrive = DifferentialDriveConstants.MYDRIVE;

    private DifferentialDrive() {
    }

    public static DifferentialDrive getInstance() {
        return INSTANCE;
    }

    /**
     * Command that control on right and left side of a tank.
     *
     * @param leftSpeed a supplier parameter of the controlling to the left side
     * @param rightSpeed a supplier parameter of the controlling to the right side
     * @return the functionalCommand
     */
    public CommandBase tankDriveCommand(Supplier<Double> leftSpeed, Supplier<Double> rightSpeed) {
        return new FunctionalCommand(
                () -> {
                },
                () -> tankDrive(leftSpeed, rightSpeed),
                (interrupted) -> stop(),
                () -> false,
                this
        );
    }

    /**
     * Command that control tank with rotation and forward.
     *
     * @param turnSpeed a supplier parameter of the rotation of the tank
     * @param forwardSpeed a supplier parameter that control the drive speed
     * @return a functionalCommand
     */
    public CommandBase arcadeDriveCommand(Supplier<Double> turnSpeed, Supplier<Double> forwardSpeed) {
        return new FunctionalCommand(
                () -> {
                },
                () ->arcadeDrive(forwardSpeed, turnSpeed),
                (interrupted) -> stop(),
                () -> false,
                this
        );
    }

    /**
     *  Command that control tank with rotation and forward and can self rotate.
     *
     * @param turnSpeed a supplier parameter of the rotation of the tank
     * @param forwardSpeed a supplier parameter that control the drive speed
     * @param turnInPlace a supplier parameter that can rotate in the place
     * @return a functionalCommand
     */
    public CommandBase curvatureDriveCommand(Supplier<Double> turnSpeed, Supplier<Double> forwardSpeed, Supplier<Boolean>turnInPlace) {
        return new FunctionalCommand(
                () -> {
                },
                () ->curvatureDrive(forwardSpeed, turnSpeed, turnInPlace),
                (interrupted) -> stop(),
                () -> false,
                this
        );
    }

    private void tankDrive(Supplier<Double> turnSpeed, Supplier<Double> forwardSpeed){
         myDrive.tankDrive(turnSpeed.get(),  forwardSpeed.get());
    }
    private void arcadeDrive(Supplier<Double> turnSpeed, Supplier<Double> forwardSpeed){
        myDrive.arcadeDrive(forwardSpeed.get(), turnSpeed.get());
    }
    private void curvatureDrive(Supplier<Double> turnSpeed, Supplier<Double> forwardSpeed, Supplier<Boolean> selfRotation){
        myDrive.curvatureDrive( turnSpeed.get(),  forwardSpeed.get(), selfRotation.get());
    }

    private void stop() {
        myDrive.stopMotor();
    }


}


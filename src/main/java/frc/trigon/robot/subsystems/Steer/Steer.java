package frc.trigon.robot.subsystems.Steer;


import com.ctre.phoenixpro.controls.PositionVoltage;
import com.ctre.phoenixpro.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.*;
import frc.trigon.robot.subsystems.collector.CollectorConstants;

import java.util.function.Supplier;

public class Steer extends SubsystemBase {
    private final static Steer INSTANCE = new Steer();

    private final TalonFX motor = SteerConstants.MOTOR;

    public static Steer getInstance() {
        return INSTANCE;
    }

    private Steer() {
    }

    public CommandBase getAngleSequenceCommand(){
        return new SequentialCommandGroup(
                getSetTargetAngleCommand(90).withTimeout(3),
                getSetTargetAngleCommand(180).withTimeout(3),
                getSetTargetAngleCommand(0)
        );
    }

    public CommandBase getSetTargetAngleCommand(double targetAngle){
        return new StartEndCommand(
                () -> setTargetAngle(targetAngle),
                this::stop,
                this
        );
    }

    public CommandBase getSetTargetAngleCommand(Supplier<Double> targetAngle) {
        return new FunctionalCommand(
                () -> {},
                () -> setTargetAngle(targetAngle.get()),
                (interrupted) -> stop(),
                () -> false,
                this
        );
    }

    private void setTargetAngle(double angelDegrees) {
        double systemRevolutions = angelDegrees / 360;
        double motorRevolutions = systemRevolutions * SteerConstants.GEAR_RATIO;
        PositionVoltage request = new PositionVoltage(motorRevolutions);
        motor.setControl(request);

    }

    private void stop() {
        motor.stopMotor();
    }


}

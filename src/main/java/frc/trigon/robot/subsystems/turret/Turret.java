package frc.trigon.robot.subsystems.turret;


import com.ctre.phoenixpro.controls.VoltageOut;
import com.ctre.phoenixpro.hardware.TalonFX;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.FunctionalCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.function.Supplier;

public class Turret extends SubsystemBase {
    private final static Turret INSTANCE = new Turret();
    private final TalonFX motor = TurretConstants.MOTOR;
    private final PIDController pidController = TurretConstants.PID_CONTROLLER;

    private Turret() {
    }

    public static Turret getInstance() {
        return INSTANCE;
    }

    /**
     * create command 
     *
     * @param hasTargetSupplier a supplier that returns whether there is a reflector visible
     * @param positionSupplier  a supplier the position of the reflector
     * @return
     */
    public CommandBase getAlignToReflectorCommand(Supplier<Boolean> hasTargetSupplier, Supplier<Double> positionSupplier) {
        return new FunctionalCommand(
                () -> {},
                () -> alignToReflector(hasTargetSupplier.get(), positionSupplier.get()),
                (interrupted) -> stop(),
                () -> false,
                this
        );
    }

    private void alignToReflector(boolean hasTarget, double position) {
        if (!hasTarget) {
            VoltageOut request = new VoltageOut(5);
            motor.setControl(request);
            return;
        }

        VoltageOut request = new VoltageOut(pidController.calculate(position));
        motor.setControl(request);
    }

    private void stop() {
        motor.stopMotor();
    }
}



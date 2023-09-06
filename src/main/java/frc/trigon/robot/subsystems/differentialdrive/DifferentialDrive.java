package frc.trigon.robot.subsystems.differentialdrive;

import com.ctre.phoenixpro.hardware.TalonFX;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class DifferentialDrive {
    private final TalonFX
            FRONT_RIGHT_MOTOR = DifferentialDriveConstants.FRONT_RIGHT_MOTOR,
            BACK_RIGHT_MOTOR = DifferentialDriveConstants.BACK_RIGHT_MOTOR,
            FRONT_LEFT_MOTOR = DifferentialDriveConstants.FRONT_LEFT_MOTOR,
            BACK_LEFT_MOTOR = DifferentialDriveConstants.BACK_LEFT_MOTOR;

    private final MotorControllerGroup
        left_Motor_Group = DifferentialDriveConstants.LEFT_MOTOR_GROUP,
        right_Motor_Group = DifferentialDriveConstants.RIGHT_MOTOR_GROUP;



    private void stop(){
        FRONT_LEFT_MOTOR.stopMotor();
        FRONT_RIGHT_MOTOR.stopMotor();
        BACK_LEFT_MOTOR.stopMotor();
        BACK_RIGHT_MOTOR.stopMotor();
    }


}

package frc.trigon.robot.subsystems.differentialdrive;


import com.ctre.phoenixpro.configs.TalonFXConfiguration;
import com.ctre.phoenixpro.hardware.TalonFX;
import com.ctre.phoenixpro.signals.InvertedValue;
import com.ctre.phoenixpro.signals.NeutralModeValue;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DifferentialDriveConstants extends SubsystemBase {


    private final static DifferentialDriveConstants INSTANCE = new DifferentialDriveConstants();

    public static DifferentialDriveConstants getInstance() {
        return INSTANCE;
    }

    private DifferentialDriveConstants() {

    }
    private static final int
            FRONT_RIGHT_MOTOR_ID = 0,
            BACK_RIGHT_MOTOR_ID = 1,
            FRONT_LEFT_MOTOR_ID = 2,
            BACK_LEFT_MOTOR_ID = 3;

    private static final InvertedValue INVERTED = InvertedValue.CounterClockwise_Positive;
    private static final NeutralModeValue NEUTRAL_MODE_VALUE = NeutralModeValue.Brake;

    static final TalonFX
            FRONT_RIGHT_MOTOR = new TalonFX(FRONT_RIGHT_MOTOR_ID),
            BACK_RIGHT_MOTOR = new TalonFX(BACK_RIGHT_MOTOR_ID),
            FRONT_LEFT_MOTOR = new TalonFX(FRONT_LEFT_MOTOR_ID),
            BACK_LEFT_MOTOR = new TalonFX(BACK_LEFT_MOTOR_ID);

    static final MotorControllerGroup LEFT_MOTOR_GROUP = new MotorControllerGroup(FRONT_LEFT_MOTOR,BACK_LEFT_MOTOR);
    static final MotorControllerGroup RIGHT_MOTOR_GROUP = new MotorControllerGroup(FRONT_RIGHT_MOTOR,BACK_RIGHT_MOTOR);
    static {
        TalonFXConfiguration configuration = new TalonFXConfiguration();

        configuration.Audio.BeepOnBoot = false;
        configuration.MotorOutput.Inverted = INVERTED;
        configuration.MotorOutput.NeutralMode = NEUTRAL_MODE_VALUE;

        BACK_LEFT_MOTOR.getConfigurator().apply(configuration);
        FRONT_LEFT_MOTOR.getConfigurator().apply(configuration);
        BACK_RIGHT_MOTOR.getConfigurator().apply(configuration);
        FRONT_LEFT_MOTOR.getConfigurator().apply(configuration);


    }

}


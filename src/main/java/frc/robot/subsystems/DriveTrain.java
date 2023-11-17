package frc.robot.subsystems;

// imports
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveTrainConstants;

public class DriveTrain extends SubsystemBase {
  /*declare motor controllers
   * CANSparkMax
   * Give them ID's from constants*/
  private CANSparkMax frontLeft =
      new CANSparkMax(DriveTrainConstants.FRONT_LEFT_MOTOR_ID, MotorType.kBrushless);
  private CANSparkMax backLeft =
      new CANSparkMax(DriveTrainConstants.BACK_LEFT_MOTOR_ID, MotorType.kBrushless);
  private CANSparkMax frontRight =
      new CANSparkMax(DriveTrainConstants.FRONT_RIGHT_MOTOR_ID, MotorType.kBrushless);
  private CANSparkMax backRight =
      new CANSparkMax(DriveTrainConstants.BACK_RIGHT_MOTOR_ID, MotorType.kBrushless);

  // Make motor controller groups
  private MotorControllerGroup m_leftGroup = new MotorControllerGroup(frontLeft, backLeft);
  private MotorControllerGroup m_rightGroup = new MotorControllerGroup(frontRight, backRight);
  // Declare DifferentialDrive
  private DifferentialDrive m_differentialDrive = new DifferentialDrive(m_leftGroup, m_rightGroup);
  // Arcade drive

  public void arcadeDrive(double speed, double rotation) {
    m_differentialDrive.arcadeDrive(-speed, -rotation);
  }
}

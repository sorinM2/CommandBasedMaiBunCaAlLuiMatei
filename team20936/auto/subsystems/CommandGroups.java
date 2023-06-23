package org.firstinspires.ftc.teamcode.team20936.auto.subsystems;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.team20936.auto.autoCommands.BasicCommands.CloseClaw;
import org.firstinspires.ftc.teamcode.team20936.auto.autoCommands.BasicCommands.GotoLinearHeading;
import org.firstinspires.ftc.teamcode.team20936.auto.autoCommands.BasicCommands.LatchClose;
import org.firstinspires.ftc.teamcode.team20936.auto.autoCommands.BasicCommands.LatchOpen;
import org.firstinspires.ftc.teamcode.team20936.auto.autoCommands.BasicCommands.MedianClaw;
import org.firstinspires.ftc.teamcode.team20936.auto.autoCommands.BasicCommands.OpenClaw;
import org.firstinspires.ftc.teamcode.team20936.auto.autoCommands.BasicCommands.SetArmRevPos;
import org.firstinspires.ftc.teamcode.team20936.auto.autoCommands.BasicCommands.SetLiftPos;
import org.firstinspires.ftc.teamcode.team20936.auto.autoCommands.BasicCommands.SetWristPos;
import org.firstinspires.ftc.teamcode.team20936.auto.autoCommands.BasicCommands.SetWristRevPos;
import org.firstinspires.ftc.teamcode.team20936.auto.autoCommands.BasicCommands.SorinMakesBetterWaitCommands;
import org.firstinspires.ftc.teamcode.team20936.auto.autoCommands.ExtendedCommands.LowPos;

public class CommandGroups {
    public static SequentialCommandGroup DepositGroup(){
        return new SequentialCommandGroup(
                new LatchOpen(),
                new SetArmRevPos(-27),
                new SetWristRevPos(0.99),
                new SorinMakesBetterWaitCommands(500),
                new SetArmRevPos(-50),
                new SetWristPos(0.624),
                new SorinMakesBetterWaitCommands(400),
                new MedianClaw(),
                new LatchClose(),
                new SorinMakesBetterWaitCommands(300),
                new SetArmRevPos(-27),
                new SorinMakesBetterWaitCommands(150),
                new LowPos(),
                new OpenClaw(),
                new SorinMakesBetterWaitCommands(100)
        );
    }

    public static SequentialCommandGroup CatchConeGroup(int ArmRevPos){
        return new SequentialCommandGroup(
                new SetWristPos(0.32),
                new SetWristRevPos(0.41),
                new SorinMakesBetterWaitCommands(200),
                new SetArmRevPos(ArmRevPos),
                new SorinMakesBetterWaitCommands(600),
                new CloseClaw(),
                new SorinMakesBetterWaitCommands(350),
                new SetArmRevPos(-80, 1)
        );
    }

    public static SequentialCommandGroup TransferConeGroup(double PosX, double PosY, double Degrees_Heading)
    {
        return new SequentialCommandGroup(
                new SorinMakesBetterWaitCommands(100),

                new SetLiftPos(1000 ),
                new SorinMakesBetterWaitCommands(100),
                new SetArmRevPos(-80),
                new GotoLinearHeading(PosX, PosY, Degrees_Heading),
                new LatchOpen(),
                new SorinMakesBetterWaitCommands(100),
                new SetLiftPos(0),
                new SorinMakesBetterWaitCommands(150)
        );
    }

    public static SequentialCommandGroup TransferConeGroup(double PosX, double PosY, double Degrees_Heading, int liftpos)
    {
        return new SequentialCommandGroup(
                new SorinMakesBetterWaitCommands(100),
                new SetLiftPos(liftpos ),
                new SorinMakesBetterWaitCommands(100),
                new SetArmRevPos(-80),
                new GotoLinearHeading(PosX, PosY, Degrees_Heading),
                new LatchOpen(),
                new SorinMakesBetterWaitCommands(100),
                new SetLiftPos(0),
                new SorinMakesBetterWaitCommands(150)

        );
    }
    private CommandGroups(){}
}

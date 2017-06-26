package io2;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class BufferedOutputStreamTest {
    public static void main(String[] args) throws Exception {
        OutputStream io = new FileOutputStream("d:/out.txt");

        BufferedOutputStream out = new BufferedOutputStream(io);

        String str = "一个兽人，一个真正的兽人战士，他一生的追求只有一个：在与敌人的决战中光荣的战死沙场。　你们当中的许多人没有参加过真正的战斗。和平，和平已经伴随了我们许多年。这些年来，我们无所事事，但我们也曾奋战过许多年。今天，如果我们战死，死在这片战场上，我们虽死犹荣。今天，如果我们战死，那是为了保卫我们的孩子，我们的父母，我们的......爱人。我们誓死抵抗。我们誓不言败。我们是一个整体，一个团结起来的整体。我们将获得胜利，而它们的神必将失败。";

        out.write(str.getBytes());

        out.close();

        io.close();

    }
}	

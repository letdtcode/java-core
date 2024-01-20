package com.mascara.tranferfile;

/**
 * Created by: IntelliJ IDEA
 * User      : boyng
 * Date      : 20/01/2024
 * Time      : 8:08 CH
 * Filename  : ClientTransferMain
 */
public class ClientTransferMain {
    public static void main(String[] args) {
        ClientTransferView view=new ClientTransferView();
        new ClientTransferController(view);
    }
}

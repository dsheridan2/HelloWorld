import java.io.FileWriter;

public class WriteFile {
    
    public static void writeZone(Station[] array) {

        try {
            FileWriter write = new FileWriter("fbZone_" + array[0].getZone() + ".awl");

            write.write("FUNCTION_BLOCK \"fbZONE_" + array[0].getZone() + "\"\n");
            write.write("TITLE = ZONE " + array[0].getZone() + "\n");
            write.write("VERSION : 0.1\n\n");
            write.write("BEGIN\n");
            for (int i = 0; i < 16; i++) {
                if (array[i].isUsed) {

                    write.write("NETWORK\n");
                    write.write("TITLE = Station " + array[0].getZone() + " - " + array[i].getStation() + "\n");

                    write.write("      CALL \"fbStationFull\", \"dbSta" + array[i].getZone() + "_" + array[i].getStation() + "\n");
                    write.write("      ( bINFirstStation          := " + array[i].getFirst() + " ,\n");
                    write.write("         bINLastStation          := " + array[i].getLast() + " ,\n");
                    write.write("         byteIN_ZONE             := " + array[i].getZone() + " ,\n");
                    write.write("         byteIN_STATION          := " + array[i].getStation() + " ,\n");

                    for (int k = 0; k < 8; k++) {

                        if (array[i].getGenericIN(k) != null && array[i].getGenericIN(k) != "") write.write("         bINGenericInput" + k + "        := " + array[i].getGenericIN(k) + " ,\n");

                    }

                    for (int k = 0; k < 8; k++) {

                        if (array[i].getGenericOUT(k) != null && array[i].getGenericOUT(k) != "") write.write("         bOUTGenericOutput" + k + "      := " + array[i].getGenericOUT(k) + " ,\n");
                        
                    }

                    write.write("         bOUTCylAdvance          := \n");
                    write.write("      );\n\n");

                    if (array[i].getCamera()) {

                        write.write("      CALL \"fbMultiCam\", \"dbSta" + array[i].getZone() + "_" + array[i].getStation() + "Camera\"\n");
                        write.write("      (  iIN_NumberOfCameras     := \n");
                        write.write("      );\n\n");

                    }

                    if (array[i].getScanner()) {

                        write.write("      CALL \"fbScannerTool\", \"dbSta" + array[i].getZone() + "_" + array[i].getStation() + "Scanner\"\n");
                        write.write("      (  byteIN_Zone             := " + array[i].getZone() + " ,\n");
                        write.write("         byteIN_Station          := " + array[i].getStation() + " ,\n");
                        write.write("         iIN_NumberOfScanners    := \n");
                        write.write("      );\n\n");

                    }

                    if (array[i].getTMD()) {

                        write.write("      CALL \"fcTMD\"\n");
                        write.write("      (  DB_Station              := \"dbSta" + array[i].getZone() + "_" + array[i].getStation() + "\n");
                        write.write("      );\n\n");

                    }
                }
            }

            write.write("END_FUNCTION_BLOCK");
            write.close();
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }
    }
}

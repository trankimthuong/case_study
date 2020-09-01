package server.entities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GetData {
    public ArrayList<AdminAccount> getAdminAccount(){
        String adminFile = "D:\\NewCodeGym\\casestudy_module2\\CaseStudy_module2\\src\\server\\storage\\admin_account.txt";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<AdminAccount> adminAccounts = new ArrayList<>();

        try{
            br = new BufferedReader(new FileReader(adminFile));
            while ((line = br.readLine()) != null) {

                // tra ve 1 admin account 1 mang chua name va password
                String[] bufferAccount = line.split(cvsSplitBy);

                adminAccounts.add(new AdminAccount(bufferAccount[0], bufferAccount[1]));
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(br != null){
                try{
                    br.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return adminAccounts;
    }

    public ArrayList<Client> getClients(){
        String adminFile = "D:\\NewCodeGym\\casestudy_module2\\CaseStudy_module2\\src\\server\\storage\\client.txt";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<Client> clients = new ArrayList<>();

        try{
            br = new BufferedReader(new FileReader(adminFile));
            while ((line = br.readLine()) != null) {

                // tra ve 1 admin account 1 mang chua name va password
                String[] bufferClient = line.split(cvsSplitBy);

                clients.add(new Client(Long.parseLong(bufferClient[0]), bufferClient[1],Double.parseDouble(bufferClient[2])));
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(br != null){
                try{
                    br.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return clients;
    }

}

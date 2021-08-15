package com.javaprep.concurrency.udemy.vault;

import com.javaprep.concurrency.udemy.ThreadCreation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CrackTheVault {
    int MAX_PASSWORD = 10;

    public void start() {
        Random random = new Random();
        Vault vault = new Vault(random.nextInt(MAX_PASSWORD));
        List<Thread> threads = new ArrayList<>();
        threads.add(new AscendingHacker(vault));
        threads.add(new DescendingHacker(vault));
        threads.add(new PoliceThread());
        for (Thread thread : threads) {
            thread.start();
        }
    }

    public class Vault {
        private int password;

        Vault(int pass) {
            this.password = pass;
        }

        public boolean isPassword(int pass) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
            return this.password == pass;
        }
    }

    private abstract class HackerThread extends Thread {
        protected Vault vault;

        public HackerThread(Vault vault) {
            this.vault = vault;
            this.setName(this.getClass().getSimpleName());
            this.setPriority(Thread.MAX_PRIORITY);
        }

        @Override
        public synchronized void start() {
            System.out.println("Starting thread : " + this.getName());
            super.start();
        }
    }

    private class AscendingHacker extends HackerThread {

        public AscendingHacker(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for (int i  = 0 ; i < MAX_PASSWORD; i++) {
                if (vault.isPassword(i)) {
                    System.out.println(this.getName() + " guessed the password");
                    System.exit(0);
                }
            }
        }
    }

    private class DescendingHacker extends HackerThread {

        public DescendingHacker(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for (int i = MAX_PASSWORD; i > 0; i--) {
                if (vault.isPassword(i)) {
                    System.out.println(this.getName() + " guessed the password");
                    System.exit(0);
                }
            }
        }
    }

    private class PoliceThread extends Thread {
        @Override
        public void run() {
            this.setName(this.getClass().getSimpleName());
            for (int i = 10; i > 0; i--) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
                System.out.println(i+ " seconds remaining before "+this.getName()+" arrives");
            }
            System.out.println("Game Over, you have been caught by "+this.getName()+"!!");
            System.exit(0);
        }

    }
}

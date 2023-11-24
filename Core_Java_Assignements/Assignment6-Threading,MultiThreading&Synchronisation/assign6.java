import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Program 1: Prime numbers in a given range using multithreading
class PrimeFinder extends Thread {
    private int start, end;

    PrimeFinder(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {
        System.out.println("Prime numbers in the range " + start + " to " + end + ":");
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

// Program 2: Increment variable using thread
class Incrementer extends Thread {
    private int value;

    Incrementer(int value) {
        this.value = value;
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
                value++;
                System.out.println("Incremented value: " + value);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Program 3: Joint account withdrawal
class Account {
    private int balance = 1000;

    synchronized void withdraw(int amount, String person) {
        System.out.println(person + " is withdrawing " + amount + " from the joint account.");
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Remaining balance after withdrawal: " + balance);
        } else {
            System.out.println("Insufficient funds! Cannot withdraw " + amount);
        }
    }
}

class JointAccountHolder extends Thread {
    private Account account;
    private int withdrawalAmount;
    private String person;

    JointAccountHolder(Account account, int withdrawalAmount, String person) {
        this.account = account;
        this.withdrawalAmount = withdrawalAmount;
        this.person = person;
    }

    public void run() {
        account.withdraw(withdrawalAmount, person);
    }
}

// Program 4: Stack operations using wait and notify
class SharedStack {
    private final int maxSize = 5;
    private Queue<Integer> stack = new LinkedList<>();

    synchronized void push(int value) {
        while (stack.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        stack.add(value);
        System.out.println("Pushed " + value + " onto the stack.");
        notify();
    }

    synchronized int pop() {
        while (stack.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int poppedValue = stack.poll();
        System.out.println("Popped " + poppedValue + " from the stack.");
        notify();
        return poppedValue;
    }
}

class StackPusher extends Thread {
    private SharedStack stack;
    private int value;

    StackPusher(SharedStack stack, int value) {
        this.stack = stack;
        this.value = value;
    }

    public void run() {
        stack.push(value);
    }
}

class StackPopper extends Thread {
    private SharedStack stack;

    StackPopper(SharedStack stack) {
        this.stack = stack;
    }

    public void run() {
        stack.pop();
    }
}

// Program 5: Resource sharing simulation
class Coordinator {
    private final int totalResources = 5;

    synchronized int requestResource(String user) {
        while (totalResources == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        totalResources--;
        System.out.println(user + " is using a resource. Total resources now: " + totalResources);
        notify();
        return totalResources;
    }

    synchronized void releaseResource(String user) {
        while (totalResources == 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        totalResources++;
        System.out.println(user + " released a resource. Total resources now: " + totalResources);
        notify();
    }
}

class User extends Thread {
    private Coordinator coordinator;
    private String userName;

    User(Coordinator coordinator, String userName) {
        this.coordinator = coordinator;
        this.userName = userName;
    }

    public void run() {
        try {
            while (true) {
                coordinator.requestResource(userName);
                Thread.sleep((long) (Math.random() * 5000 + 5000));
                coordinator.releaseResource(userName);
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Program 6: Mice in a box simulation
class Box {
    private final int maxMice = 4;
    private int miceInside = 0;

    synchronized void enter(String mouseName) {
        while (miceInside == maxMice) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        miceInside++;
        System.out.println(mouseName + " entered the box. Mice inside now: " + miceInside);
        notify();
    }

    synchronized void exit(String mouseName) {
        while (miceInside == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        miceInside--;
        System.out.println(mouseName + " exited the box. Mice inside now: " + miceInside);
        notify();
    }
}

class Mouse extends Thread {
    private Box box;
    private String mouseName;

    Mouse(Box box, String mouseName) {
        this.box = box;
        this.mouseName = mouseName;
    }

    public void run() {
        try {
            while (true) {
                box.exit(mouseName);
                Thread.sleep((long) (Math.random() * 8000 + 5000));
                box.enter(mouseName);
                Thread.sleep((long) (Math.random() * 3000 + 5000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Program 7: Producer and Consumer
class Buffer {
    private ArrayList<Integer> items = new ArrayList<>();
    private final int maxSize = 5;

    synchronized void produce(int item) {
        while (items.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        items.add(item);
        System.out.println("Produced item: " + item);
        notify();
    }

    synchronized int consume() {
        while (items.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int consumedItem = items.remove(0);
        System.out.println("Consumed item: " + consumedItem);
        notify();
        return consumedItem;
    }
}

class Producer extends Thread {
    private Buffer buffer;

    Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            buffer.produce(i);
        }
    }
}

class Consumer extends Thread {
    private Buffer buffer;

    Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.consume();
        }
    }
}

// Program 8: Producer and Two Consumers with Queue
class BufferQueue {
    private Queue<Integer> items = new LinkedList<>();
    private final int maxSize = 5;

    synchronized void produce(int item) {
        while (items.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        items.add(item);
        System.out.println("Producer produced item: " + item);
        notifyAll();
    }

    synchronized int consume(String consumerName) {
        while (items.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int consumedItem = items.remove();
        System.out.println(consumerName + " consumed item: " + consumedItem);
        notifyAll();
        return consumedItem;
    }
}

class QueueProducer extends Thread {
    private BufferQueue buffer;

    QueueProducer(BufferQueue buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            buffer.produce(i);
        }
    }
}

class QueueConsumer extends Thread {
    private BufferQueue buffer;
    private String consumerName;

    QueueConsumer(BufferQueue buffer, String consumerName) {
        this.buffer = buffer;
        this.consumerName = consumerName;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.consume(consumerName);
        }
    }
}

// Program 9: Producer produces item for a specific consumer
class ItemProducer extends Thread {
    private BufferQueue buffer;
    private String consumerName;

    ItemProducer(BufferQueue buffer, String consumerName) {
        this.buffer = buffer;
        this.consumerName = consumerName;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            buffer.produceForConsumer(i, consumerName);
        }
    }
}

// Program 10: Interface inheritance
interface K1 {
    void mK();
}

interface K2 extends K1 {
}

interface K3 extends K2 {
}

class U implements K3 {
    public void mK() {
        System.out.println("Value of integer variable: " + super.x);
    }
}

// Main class
public class MultithreadingAndExceptionHandling {
    public static void main(String[] args) {
        // Program 1
        PrimeFinder thread1 = new PrimeFinder(1, 50);
        PrimeFinder thread2 = new PrimeFinder(51, 100);
        thread1.start();
        thread2.start();

        // Program 2
        Incrementer incrementerThread = new Incrementer(0);
        incrementerThread.start();

        // Program 3
        Account jointAccount = new Account();
        JointAccountHolder person1 = new JointAccountHolder(jointAccount, 500, "Person 1");
        JointAccountHolder person2 = new JointAccountHolder(jointAccount, 700, "Person 2");
        
        person1.start();
        person2.start();

        // Program 4
        SharedStack sharedStack = new SharedStack();
        StackPusher pusher1 = new StackPusher(sharedStack, 10);
        StackPusher pusher2 = new StackPusher(sharedStack, 20);
        StackPopper popper1 = new StackPopper(sharedStack);
        StackPopper popper2 = new StackPopper(sharedStack);

        pusher1.start();
        popper1.start();
        pusher2.start();
        popper2.start();

        // Program 5
        Coordinator coordinator = new Coordinator();
        User user1 = new User(coordinator, "User 1");
        User user2 = new User(coordinator, "User 2");

        user1.start();
        user2.start();

        // Program 6
        Box box = new Box();
        Mouse mouse1 = new Mouse(box, "Mouse 1");
        Mouse mouse2 = new Mouse(box, "Mouse 2");

        mouse1.start();
        mouse2.start();

        // Program 7
        Buffer buffer = new Buffer();
        Producer producerThread = new Producer(buffer);
        Consumer consumerThread = new Consumer(buffer);

        producerThread.start();
        consumerThread.start();

        // Program 8
        BufferQueue bufferQueue = new BufferQueue();
        QueueProducer queueProducer = new QueueProducer(bufferQueue);
        QueueConsumer queueConsumer1 = new QueueConsumer(bufferQueue, "Consumer 1");
        QueueConsumer queueConsumer2 = new QueueConsumer(bufferQueue, "Consumer 2");

        queueProducer.start();
        queueConsumer1.start();
        queueConsumer2.start();

        // Program 9
        ItemProducer itemProducer = new ItemProducer(bufferQueue, "Specific Consumer");
        QueueConsumer specificConsumer = new QueueConsumer(bufferQueue, "Specific Consumer");

        itemProducer.start();
        specificConsumer.start();

        // Program 10
        U uObject = new U();
        uObject.mK();
    }
}

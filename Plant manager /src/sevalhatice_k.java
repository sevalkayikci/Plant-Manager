import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

// interface eatable
interface Eatable {
    String chop();
    String eat();
}

// DayHr class
class DayHr {
    private String day;
    private String hour;
    private String duration;

    public DayHr(String day, String hour, String duration) {
        this.day = day;
        this.hour = hour;
        this.duration = duration;
    }

    public String getDay() {
        return day;
    }

    public String getHour() {
        return hour;
    }

    public String getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "day: " + day + "   hour: " + hour + "   duration: " + duration;
    }
}

// plant abstract class
abstract class Plant {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract ArrayList<DayHr> getWatered();

    public abstract void setWatered(String day, String hour, String duration);

    @Override
    public abstract String toString();
}

// fruit abstract class
abstract class Fruit extends Plant implements Eatable {
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String chop() {
        return "Don’t chop the fruit; bite it.";
    }

    @Override
    public String eat() {
        return "You should eat fruits raw.";
    }
}

// vegetable abstract class
abstract class Vegetable extends Plant implements Eatable {
    private int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String chop() {
        return "Chop the vegetable, don’t bite it.";
    }

    @Override
    public String eat() {
        return "You should eat vegetables cooked.";
    }
}

// enum for flower intensity
enum FlowerIntensity {
    Very_Strong, Strong, Middle, Weak, Very_Weak
}

// flower class
class Flower extends Plant {
    private String name;
    private FlowerIntensity intensity;
    private ArrayList<DayHr> wateringSchedule;

    public Flower(String name) {
        this.name = name;
        this.intensity = FlowerIntensity.Very_Strong; // default
        this.wateringSchedule = new ArrayList<>();
        setWatered("Monday", "10:00", "1 Hour"); // default
    }

    public Flower(String name, String color, FlowerIntensity intensity) {
        this.name = name;
        setColor(color);
        this.intensity = intensity;
        this.wateringSchedule = new ArrayList<>();
    }

    public FlowerIntensity getIntensity() {
        return intensity;
    }

    public void setIntensity(FlowerIntensity intensity) {
        this.intensity = intensity;
    }

    @Override
    public ArrayList<DayHr> getWatered() {
        return wateringSchedule;
    }

    @Override
    public void setWatered(String day, String hour, String duration) {
        wateringSchedule.add(new DayHr(day, hour, duration));
    }

    @Override
    public String toString() {
        return "Flower" +
                "\nname:" + name +
                "\ncolor: " + getColor() +
                "\nintensity: " + getIntensity() +
                "\nwatering schedule: " + wateringSchedule;
    }

}

// citrus class
class Citrus extends Fruit {
    private String cname;
    private ArrayList<DayHr> wateringSchedule;

    public Citrus(String cname) {
        this.cname = cname;
        this.wateringSchedule = new ArrayList<>();
        setWatered("Monday", "10:00", "1 Hour"); // default
    }

    public Citrus(String name, String color, double price) {
        this.cname = name;
        setColor(color);
        setPrice((int) price); // Adjusted to match the int type in Fruit
        this.wateringSchedule = new ArrayList<>();
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public ArrayList<DayHr> getWatered() {
        return wateringSchedule;
    }

    @Override
    public void setWatered(String day, String hour, String duration) {
        wateringSchedule.add(new DayHr(day, hour, duration));
    }

    @Override
    public String toString() {
        return "Citrus" +
                "\nname:" + cname +
                "\ncolor: " + getColor() +
                "\nprice: " + getPrice() + "＄"+
                "\nwatering schedule: " + wateringSchedule +
                "\n" + eat() + "" + chop();
    }
}


// apple class
class Apple extends Fruit {
    private String aname;
    private ArrayList<DayHr> wateringSchedule;

    public Apple(String aname) {
        this.aname = aname;
        this.wateringSchedule = new ArrayList<>();
        setWatered("Monday", "10:00", "1 Hour"); // default
    }

    public Apple(String name, String color, double price) {
        this.aname = name;
        setColor(color);
        setPrice((int) price); // Adjusted to match the int type in Fruit
        this.wateringSchedule = new ArrayList<>();
    }

    @Override
    public ArrayList<DayHr> getWatered() {
        return wateringSchedule;
    }

    @Override
    public void setWatered(String day, String hour, String duration) {
        wateringSchedule.add(new DayHr(day, hour, duration));
    }

    @Override
    public String toString() {
        return "Apple" +
                "\nname:" + aname +
                "\ncolor: " + getColor() +
                "\nprice: " + getPrice() + "＄"+
                "\nwatering schedule: " + wateringSchedule +
                "\n" + eat() + "" + chop();
    }
}
class Tomato extends Vegetable {
    private String kind;
    private ArrayList<DayHr> wateringSchedule;
    private ArrayList<String> products;

    public Tomato(String kind) {
        this.kind = kind;
        this.wateringSchedule = new ArrayList<>();
        this.products = new ArrayList<>();
        setWatered("Monday", "09:00", "30 minutes"); // default
        setWatered("Wednesday", "09:00", "30 minutes"); // default
        setWatered("Friday", "09:00", "30 minutes"); // default

        products.add("Tomato paste"); // default product
    }

    public Tomato(String type, String color, double weight, String product) {
        this.kind = type;
        setColor(color);
        setWeight((int) weight); // Adjusted to match the int type in Vegetable
        this.wateringSchedule = new ArrayList<>();
        this.products = new ArrayList<>();
        products.add(product);
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public ArrayList<DayHr> getWatered() {
        return wateringSchedule;
    }

    @Override
    public void setWatered(String day, String hour, String duration) {
        wateringSchedule.add(new DayHr(day, hour, duration));
    }

    public ArrayList<String> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Tomato" +
                "\nkind:" + kind +
                "\ncolor: " + getColor() +
                "\nweight: " + getWeight() +"kg"+
                "\nwatering schedule: " + wateringSchedule +
                "\nproduct: " + products + "\n" + eat() + "" + chop();

    }
}

// GUI
public class sevalhatice_k extends JFrame{
    private JComboBox<String> categoryComboBox;
    private JPanel inputPanel;
    private JTextArea resultArea;
    private List<Plant> plants;

    public sevalhatice_k() {
        plants = new ArrayList<>();

        setTitle("Plant Manager");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // panel for categories
        JPanel topPanel = new JPanel(new FlowLayout());
        categoryComboBox = new JComboBox<>(new String[]{"Flower", "Fruit", "Vegetable"});
        JButton addButton = new JButton("Add");
        JButton searchButton = new JButton("Search");
        topPanel.add(new JLabel("Select:"));
        topPanel.add(categoryComboBox);
        topPanel.add(addButton);
        topPanel.add(searchButton);

        add(topPanel, BorderLayout.NORTH);

        // input for plant
        inputPanel = new JPanel();
        add(inputPanel, BorderLayout.CENTER);

        // result
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea), BorderLayout.SOUTH);

        // add
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAddPanel((String) categoryComboBox.getSelectedItem());
            }
        });

        // search
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSearchResults();
            }
        });
    }


    private void showAddPanel(String category) {
        inputPanel.removeAll();
        inputPanel.setLayout(new GridLayout(0, 2));
        switch (category) {
            case "Flower":
                addFlowerPanel();
                break;
            case "Fruit":
                addFruitPanel();
                break;
            case "Vegetable":
                addVegetablePanel();// Default to adding a Tomato
                break;
        }
        inputPanel.revalidate();
        inputPanel.repaint();
    }

    //flowerGUI

    private void addFlowerPanel() {
        JTextField nameField = new JTextField();
        JTextField colorField = new JTextField();
        JComboBox<String> intensityComboBox = new JComboBox<>(new String[]{
                "Very Strong", "Strong", "Middle", "Weak", "Very Weak"
        });
        JComboBox<String> wateringDayComboBox = new JComboBox<>(new String[]{"Monday", "Tuesday", "Wednesday",
                "Thursday", "Friday", "Saturday", "Sunday"});
        JComboBox<String> wateringHourComboBox = new JComboBox<>(new String[]{"01:00", "02:00", "03:00", "04:00",
                "05:00", "06:00", "07:00", "08:00", "09:00",
                "10:00","11:00", "12:00", "13:00", "14:00",
                "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00", "00:00"});
        JComboBox<String> wateringDurationComboBox = new JComboBox<>(new String[]{"30 minutes", "1 hour", "2 hours",
                "3 hours", "4 hours","5 hours", "6 hours", "7 hours", "8 hours",
                "9 hours", "10 hours"});

        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Color:"));
        inputPanel.add(colorField);
        inputPanel.add(new JLabel("Smell Intensity:"));
        inputPanel.add(intensityComboBox);
        inputPanel.add(new JLabel("Watering Day:"));
        inputPanel.add(wateringDayComboBox);
        inputPanel.add(new JLabel("Watering Hour:"));
        inputPanel.add(wateringHourComboBox);
        inputPanel.add(new JLabel("Watering Duration:"));
        inputPanel.add(wateringDurationComboBox);

        JButton submitButton = new JButton("Submit");
        inputPanel.add(new JLabel());
        inputPanel.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String color = colorField.getText();
                String intensityText = (String) intensityComboBox.getSelectedItem();
                FlowerIntensity intensity;
                switch (intensityText) {
                    case "Very Strong":
                        intensity = FlowerIntensity.Very_Strong;
                        break;
                    case "Strong":
                        intensity = FlowerIntensity.Strong;
                        break;
                    case "Middle":
                        intensity = FlowerIntensity.Middle;
                        break;
                    case "Weak":
                        intensity = FlowerIntensity.Weak;
                        break;
                    case "Very Weak":
                        intensity = FlowerIntensity.Very_Weak;
                        break;
                    default:
                        intensity = FlowerIntensity.Middle; // default
                        break;
                }
                String day = (String) wateringDayComboBox.getSelectedItem();
                String hour = (String) wateringHourComboBox.getSelectedItem();

                String duration = (String) wateringDurationComboBox.getSelectedItem();

                Flower flower = new Flower(name, color, intensity);
                flower.setWatered(day, hour, duration);
                plants.add(flower);
                JOptionPane.showMessageDialog(null, "added");
            }
        });
    }

    // fruit GUI
    private void addFruitPanel() {
        JLabel typeLabel = new JLabel("Select:");
        JComboBox<String> fruitTypeComboBox = new JComboBox<>(new String[]{"Citrus", "Apple", "other"});
        JTextField nameField = new JTextField();
        JTextField colorField = new JTextField();
        JTextField priceField = new JTextField();
        JTextField wateringDayField = new JTextField();
        JTextField wateringHourField = new JTextField();
        JTextField wateringDurationField = new JTextField();

        inputPanel.add(typeLabel);
        inputPanel.add(fruitTypeComboBox);
        inputPanel.add(new JLabel("name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("color:"));
        inputPanel.add(colorField);
        inputPanel.add(new JLabel("price:"));
        inputPanel.add(priceField);


        JButton submitButton = new JButton("Submit");
        inputPanel.add(new JLabel()); // Empty cell for grid alignment
        inputPanel.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String type = (String) fruitTypeComboBox.getSelectedItem();
                String name = nameField.getText();
                String color = colorField.getText();
                double price = Double.parseDouble(priceField.getText());
                String day = wateringDayField.getText();
                String hour = wateringHourField.getText();
                String duration = wateringDurationField.getText();

                if (type.equals("Citrus")) {
                    Citrus citrus = new Citrus(name, color, price);
                    plants.add(citrus);
                    JOptionPane.showMessageDialog(null, "added");
                }
                else if (type.equals("Apple")) {
                    Apple apple = new Apple(name, color, price);
                    plants.add(apple);
                    JOptionPane.showMessageDialog(null, "added");
                }
            }
        });
    }


    // VEGETABLE guı
    private void addVegetablePanel() {
        JTextField typeField = new JTextField("tomato");
        typeField.setEditable(false); // Default to tomato
        JTextField colorField = new JTextField();
        JTextField weightField = new JTextField();
        JComboBox<String> wateringDayComboBox = new JComboBox<>(new String[]{"Monday", "Tuesday", "Wednesday",
                "Thursday", "Friday", "Saturday", "Sunday"});
        JComboBox<String> productFieldComboBox = new JComboBox<>(new String[]{"Tomato Paste", "Tomato Soup"});
        JComboBox<String> wateringHourComboBox = new JComboBox<>(new String[]{"01:00", "02:00", "03:00", "04:00",
                "05:00", "06:00", "07:00", "08:00", "09:00",
                "10:00","11:00", "12:00", "13:00", "14:00",
                "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00", "00:00"});
        JComboBox<String> wateringDurationComboBox = new JComboBox<>(new String[]{"30 minutes", "1 hour", "2 hours",
                "3 hours", "4 hours","5 hours", "6 hours", "7 hours", "8 hours",
                "9 hours", "10 hours"});


        inputPanel.add(new JLabel("Type:"));
        inputPanel.add(typeField);
        inputPanel.add(new JLabel("Color:"));
        inputPanel.add(colorField);
        inputPanel.add(new JLabel("Weight:"));
        inputPanel.add(weightField);
        inputPanel.add(new JLabel("Product:"));
        inputPanel.add(productFieldComboBox);
        inputPanel.add(new JLabel("Watering Day:"));
        inputPanel.add(wateringDayComboBox);
        inputPanel.add(new JLabel("Watering Hour:"));
        inputPanel.add(wateringHourComboBox);
        inputPanel.add(new JLabel("Watering Duration:"));
        inputPanel.add(wateringDurationComboBox);

        JButton submitButton = new JButton("Submit");
        inputPanel.add(new JLabel());
        inputPanel.add(submitButton);


        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String type = typeField.getText();
                String color = colorField.getText();
                double weight = Double.parseDouble(weightField.getText());
                String product = (String) productFieldComboBox.getSelectedItem();
                String day = (String) wateringDayComboBox.getSelectedItem();
                String hour = (String) wateringHourComboBox.getSelectedItem();
                String duration = (String) wateringDurationComboBox.getSelectedItem();
                JOptionPane.showMessageDialog(null, "added");

                Tomato tomato = new Tomato(type, color, weight, product);
                tomato.setWatered(day, hour, duration);
                plants.add(tomato);
                resultArea.append("added Tomato: " + tomato + "\n");
            }
        });
    }

    private void showSearchResults() {
        resultArea.setText("all plants:");
        for (Plant plant : plants) {
            resultArea.append(plant.toString() + "\n");

        }
        resultArea.revalidate();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new sevalhatice_k().setVisible(true);
            }
        });
    }
}

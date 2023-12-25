package animals;

public abstract class Animal {
    private String name;
    private int age;
    private int weight;
    private String color;

    public void say(){
        System.out.println("Я говорю");
    }

    public void go(){
        System.out.println("Я иду");
    }

    public void drink(){
        System.out.println("Я пью");
    }

    public void eat(){
        System.out.println("Я ем");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getWeight(){
        return weight;
    }

    public String getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        String yearPadej = getYearPadej();
        if(yearPadej == null) {
            return "Возраст введен неверно";
        }
        return "Привет! меня зовут " + name
                + ", мне " + age + " " + getYearPadej() +", я вешу - "
                + weight + "кг, мой цвет - " + color;
    }
    private String getYearPadej() {
        if(this.age > 50) {
            return null;
        }
        if(this.age <= 0) {
            return null;
        }
        if(this.age >= 11 && this.age <= 19) {
            return "лет";
        }
        int ostatok = this.age % 10;
        if(ostatok == 0 || ostatok >= 5) {
            return "лет";
        }
         if(ostatok == 1) {
             return "год";
         }
         if(ostatok >=2 || ostatok <= 4) {
             return "года";
         }
         return null;
    }
}
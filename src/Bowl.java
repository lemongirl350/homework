class Bowl {
    public int foodAmount; //сколько еды в миске

    public Bowl(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public void addFood(int amount) {
        if (amount <= 0) {
            System.out.println("Неверное количество еды");
        } else {
            foodAmount += amount;
            System.out.println("Добавлено еды в миску: " + amount);
        }
    }
}

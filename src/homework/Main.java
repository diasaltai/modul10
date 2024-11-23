// Подсистемы мультимедийного центра
package homework;

class TV {
    public void turnOn() {
        System.out.println("Телевизор включён.");
    }

    public void turnOff() {
        System.out.println("Телевизор выключен.");
    }

    public void setChannel(int channel) {
        System.out.println("Канал установлен на: " + channel);
    }
}

class AudioSystem {
    public void turnOn() {
        System.out.println("Аудиосистема включена.");
    }

    public void turnOff() {
        System.out.println("Аудиосистема выключена.");
    }

    public void setVolume(int volume) {
        System.out.println("Громкость установлена на: " + volume);
    }
}

class DVDPlayer {
    public void play() {
        System.out.println("Воспроизведение DVD начато.");
    }

    public void pause() {
        System.out.println("Воспроизведение DVD приостановлено.");
    }

    public void stop() {
        System.out.println("Воспроизведение DVD остановлено.");
    }
}

class GameConsole {
    public void turnOn() {
        System.out.println("Игровая консоль включена.");
    }

    public void startGame(String game) {
        System.out.println("Игра запущена: " + game);
    }
}

// Класс фасада
class HomeTheaterFacade {
    private TV tv;
    private AudioSystem audioSystem;
    private DVDPlayer dvdPlayer;
    private GameConsole gameConsole;

    public HomeTheaterFacade(TV tv, AudioSystem audioSystem, DVDPlayer dvdPlayer, GameConsole gameConsole) {
        this.tv = tv;
        this.audioSystem = audioSystem;
        this.dvdPlayer = dvdPlayer;
        this.gameConsole = gameConsole;
    }

    public void watchMovie() {
        System.out.println("Подготовка к просмотру фильма...");
        tv.turnOn();
        audioSystem.turnOn();
        dvdPlayer.play();
    }

    public void stopMovie() {
        System.out.println("Завершение просмотра фильма...");
        dvdPlayer.stop();
        tv.turnOff();
        audioSystem.turnOff();
    }

    public void playGame(String game) {
        System.out.println("Подготовка к игре...");
        tv.turnOn();
        gameConsole.turnOn();
        gameConsole.startGame(game);
    }

    public void turnOffAll() {
        System.out.println("Выключение всей системы...");
        tv.turnOff();
        audioSystem.turnOff();
        dvdPlayer.stop();
        gameConsole.turnOn();
    }
}

// Клиентский код
public class Main {
    public static void main(String[] args) {
        TV tv = new TV();
        AudioSystem audioSystem = new AudioSystem();
        DVDPlayer dvdPlayer = new DVDPlayer();
        GameConsole gameConsole = new GameConsole();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(tv, audioSystem, dvdPlayer, gameConsole);

        homeTheater.watchMovie();
        homeTheater.stopMovie();

        homeTheater.playGame("FIFA 24");
        homeTheater.turnOffAll();
    }
}
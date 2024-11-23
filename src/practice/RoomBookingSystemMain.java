package practice;
// Подсистемы отеля

class RoomBookingSystem {
    public void bookRoom() {
        System.out.println("Номер забронирован.");
    }

    public void cancelBooking() {
        System.out.println("Бронирование номера отменено.");
    }
}

class RestaurantSystem {
    public void reserveTable() {
        System.out.println("Столик в ресторане забронирован.");
    }

    public void orderFood() {
        System.out.println("Еда заказана.");
    }
}

class EventManagementSystem {
    public void bookConferenceRoom() {
        System.out.println("Конференц-зал забронирован.");
    }

    public void orderEquipment() {
        System.out.println("Оборудование для мероприятия заказано.");
    }
}

class CleaningService {
    public void scheduleCleaning() {
        System.out.println("Уборка запланирована.");
    }

    public void performCleaning() {
        System.out.println("Уборка выполнена.");
    }
}

// Фасад

class HotelFacade {
    private RoomBookingSystem roomBooking;
    private RestaurantSystem restaurant;
    private EventManagementSystem eventManagement;
    private CleaningService cleaningService;

    public HotelFacade() {
        this.roomBooking = new RoomBookingSystem();
        this.restaurant = new RestaurantSystem();
        this.eventManagement = new EventManagementSystem();
        this.cleaningService = new CleaningService();
    }

    public void bookRoomWithServices() {
        System.out.println("Бронирование номера с услугами ресторана и уборки:");
        roomBooking.bookRoom();
        restaurant.orderFood();
        cleaningService.scheduleCleaning();
    }

    public void organizeEvent() {
        System.out.println("Организация мероприятия с бронированием оборудования и номеров:");
        roomBooking.bookRoom();
        eventManagement.bookConferenceRoom();
        eventManagement.orderEquipment();
    }

    public void reserveTableWithTaxi() {
        System.out.println("Бронирование столика в ресторане с вызовом такси:");
        restaurant.reserveTable();
        System.out.println("Такси вызвано.");
    }
}

// Клиентский код

public class RoomBookingSystemMain {
    public static void main(String[] args) {
        HotelFacade hotelFacade = new HotelFacade();

        hotelFacade.bookRoomWithServices();
        hotelFacade.organizeEvent();
        hotelFacade.reserveTableWithTaxi();
    }
}
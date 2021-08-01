/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.controller;

import com.mycompany.spring_mvc_project_final.entities.BookingDetailEntity;
import com.mycompany.spring_mvc_project_final.entities.BookingEntity;
import com.mycompany.spring_mvc_project_final.entities.CreditCardEntity;
import com.mycompany.spring_mvc_project_final.entities.GuestEntity;
import com.mycompany.spring_mvc_project_final.entities.PersonEntity;
import com.mycompany.spring_mvc_project_final.entities.PromotionEntity;
import com.mycompany.spring_mvc_project_final.entities.RoomEntity;
import com.mycompany.spring_mvc_project_final.entities.ServiceBookingEntity;
import com.mycompany.spring_mvc_project_final.entities.ServiceEntity;
import com.mycompany.spring_mvc_project_final.entities.paymentEntity;
import com.mycompany.spring_mvc_project_final.enums.Gender;
import com.mycompany.spring_mvc_project_final.enums.bookingstatus;
import com.mycompany.spring_mvc_project_final.service.BookingDetailService;
import com.mycompany.spring_mvc_project_final.service.BookingService;
import com.mycompany.spring_mvc_project_final.service.CreditCardService;
import com.mycompany.spring_mvc_project_final.service.ImageService;
import com.mycompany.spring_mvc_project_final.service.PaymentService;
import com.mycompany.spring_mvc_project_final.service.PromotionService;
import com.mycompany.spring_mvc_project_final.service.RoomService;
import com.mycompany.spring_mvc_project_final.service.RoomTypeService;
import com.mycompany.spring_mvc_project_final.service.ServiceBookingService;
import com.mycompany.spring_mvc_project_final.service.ServiceService;
import com.mycompany.spring_mvc_project_final.utils.SecurityUtils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class HomeController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private BookingDetailService bookingDetailService;

    @Autowired
    private ServiceBookingService serviceBookingService;

    @Autowired
    private CreditCardService creditCardService;

    @Autowired
    private RoomTypeService roomTypeService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private PromotionService promotionService;
    @Autowired
    private ServiceService serviceService;

//    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("title", "Welcome");
//      
        model.addAttribute("limit", roomService.getlimit(0));
        model.addAttribute("roomtype", roomTypeService.getRoomType());
        model.addAttribute("date", java.time.LocalDate.now());
//        model.addAttribute("countroom", roomService.getcountRoom());
//        model.addAttribute("countroom", roomService.getlimit1());

//        List<String> roles = SecurityUtils.getRolesOfUser();
//        if (!CollectionUtils.isEmpty(roles) && (roles.contains("ROLE_ADMIN")
//                || roles.contains("ROLE_SELLER") || roles.contains("ROLE_MANAGER"))) {
//            return "redirect:/admin/home";
//        }
        return "Home_Page";
    }
//    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------

    @RequestMapping("/room_type/{page}")
    public String roomtype(Model model,
            @PathVariable("page") int page) {
        model.addAttribute("roomtype", roomTypeService.getRoomType());
        model.addAttribute("room", roomService.getAllRooom());
        model.addAttribute("limit", roomService.getlimit(page));
        model.addAttribute("countroom", roomService.getcountRoom());
        model.addAttribute("image", imageService.getImage());
        return "Room_type_Page";
    }

//    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping("/about_page")
    public String About_page() {
        return "about_page";
    }

//    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping("/login")
    public String loginPage(Model model, @RequestParam(value = "error", required = false) boolean error) {
        if (error) {
            model.addAttribute("message", "Login Fail!!!");
        }
        return "login";
    }

//    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping("/403")
    public String accessDenied(Model model) {
        return "403Page";
    }

//    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String getBooking(Model model, HttpSession session,
            @RequestParam(name = "check_in", required = false) String check_in,
            @RequestParam(name = "check_out", required = false) String check_out,
            @RequestParam(name = "roomTypeId", required = false) int roomTypeId) {
        if (check_in.isEmpty() || check_out.isEmpty()) {
            model.addAttribute("message", "Please enter check-in date and check-out date !");
            model.addAttribute("roomtype", roomTypeService.getRoomType());
            return "redirect:/home";
        } else {
            long night = 0;
            LocalDate dateCheckIn = LocalDate.now();
            LocalDate dateCheckOut = LocalDate.now();
            try {
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                dateCheckIn = LocalDate.parse(check_in, dateTimeFormatter);
                dateCheckOut = LocalDate.parse(check_out, dateTimeFormatter);
                night = dateCheckOut.compareTo(dateCheckIn);
                if (night == 0) {
                    night = night + 1;
                }
            } catch (Exception e) {
            }

            if (dateCheckOut.isBefore(dateCheckIn)) {
                model.addAttribute("message", "Enter Check-in Less Than Check-out !!!");
                return "Home_Page";
            } else if (dateCheckIn == dateCheckOut) {

                model.addAttribute("roomtype", roomTypeId);
//        model.addAttribute("checkin", check_in);
                session.setAttribute("checkin", check_in);
//        model.addAttribute("checkout", check_out);
                session.setAttribute("checkout", check_out);

                model.addAttribute("search", roomService.getBookingEntity(dateCheckIn, dateCheckOut, roomTypeId));
//        List<RoomEntity> roomEntitys = roomService.getBookingEntity(date1, date2, roomTypeId);
                model.addAttribute("roomtype_id", roomTypeService.getRoomType());
                double discounts = 0;
                List<PromotionEntity> promotionEntitys = promotionService.getpromotion(roomTypeId, LocalDate.now());
                for (PromotionEntity promotionEntity : promotionEntitys) {
                    if (promotionEntity.getId() > 0) {
                        discounts = promotionEntity.getDiscount();
                    }
                }
                session.setAttribute("discounts", discounts);
                session.setAttribute("night", night);

//        model.addAttribute("search", rooms);
                return "searchBooking";
            }

            {

                model.addAttribute("roomtype", roomTypeId);
//        model.addAttribute("checkin", check_in);
                session.setAttribute("checkin", check_in);
//        model.addAttribute("checkout", check_out);
                session.setAttribute("checkout", check_out);
                model.addAttribute("search", roomService.getBookingEntity(dateCheckIn, dateCheckOut, roomTypeId));
//        List<RoomEntity> roomEntitys = roomService.getBookingEntity(date1, date2, roomTypeId);
                model.addAttribute("roomtype_id", roomTypeService.getRoomType());
                double discounts = 0;
                List<PromotionEntity> promotionEntitys = promotionService.getpromotion(roomTypeId, LocalDate.now());
                for (PromotionEntity promotionEntity : promotionEntitys) {
                    if (promotionEntity.getId() > 0) {
                        discounts = promotionEntity.getDiscount();
                    }
                }
                session.setAttribute("dateCheckin", dateCheckIn);
                session.setAttribute("dateCheckout", dateCheckOut);
                session.setAttribute("discounts", discounts);
                session.setAttribute("night", night);
                session.setAttribute("roomtype_id1", roomTypeId);
//        model.addAttribute("search", rooms);
                return "searchBooking";
            }
        }
    }
    //    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------

    @RequestMapping("/booking/{room_id}")
    public String addBooking(Model model,
            HttpSession session,
             @PathVariable(name = "room_id", required = false) int room_id
    ) {
        BookingEntity booking = (BookingEntity) session.getAttribute("booking");
// co booking
        if (booking != null) {
            List<BookingDetailEntity> details = booking.getBookingDetail();
            if (details != null && details.size() > 0) {
                // co room
                boolean isExist = false;
                for (BookingDetailEntity bd : details) {
                    if (bd.getRoom() != null && bd.getRoom().getId() == room_id) {
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) {
                    RoomEntity room = roomService.getmybooking(room_id);
                    BookingDetailEntity bd = new BookingDetailEntity();
                    bd.setBooking(booking);
                    bd.setPrice(room.getPrice());
                    bd.setRoom(room);
                    bd.setDiscount((double) session.getAttribute("discounts"));
                    bd.setPrice((room.getPrice() * (100 - (double) session.getAttribute("discounts"))) / 100);

                    //set data cho booking detal
                    details.add(bd);
                }
            } //co booking nhung user xoa het booking detail (ko co room)
            else {
                RoomEntity room = roomService.getmybooking(room_id);
                details = new ArrayList<>();
                BookingDetailEntity bd = new BookingDetailEntity();
                bd.setBooking(booking);
                bd.setPrice(room.getPrice());
                bd.setRoom(room);
                bd.setDiscount((double) session.getAttribute("discounts"));
                bd.setPrice((room.getPrice() * (100 - (double) session.getAttribute("discounts"))) / 100);

                //set data cho booking detal
                details.add(bd);

            }
            booking.setBookingDetail(details);
        } else {
            // chua co booking
            booking = new BookingEntity();
            booking.setBookingDate(new Date());
//            booking.setCheckIn(checkIn);
//            booking.setCheckIn(checkIn);

            RoomEntity room = roomService.getmybooking(room_id);
            List<BookingDetailEntity> details = new ArrayList<>();
            BookingDetailEntity bd = new BookingDetailEntity();
            bd.setBooking(booking);
            bd.setPrice(room.getPrice());
            bd.setRoom(room);
            bd.setDiscount((double) session.getAttribute("discounts"));
            bd.setPrice((room.getPrice() * (100 - (double) session.getAttribute("discounts"))) / 100);

            //set data cho booking detal
            details.add(bd);
            booking.setBookingDetail(details);
        }

        booking.setCheckIn((LocalDate) session.getAttribute("dateCheckin"));
        booking.setCheckOut((LocalDate) session.getAttribute("dateCheckout"));
        session.setAttribute("booking", booking);
        return "redirect:/view-booking";
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------

    @RequestMapping("/view-booking")
    public String viewBooking(Model model,
            HttpSession session
    ) {

        if (session.getAttribute("roomId") != null) {
            session.removeAttribute("roomId");
            session.removeAttribute("serviceBooking");
        }
        BookingEntity booking = (BookingEntity) session.getAttribute("booking");
        double totalprice = 0;
        if (booking != null && booking.getBookingDetail() != null && booking.getBookingDetail().size() > 0) {
            for (BookingDetailEntity bd : booking.getBookingDetail()) {
                // tinh total price
                double totalPriceService = 0;
                List<ServiceBookingEntity> services = bd.getServiceBooking();
                if (services != null && services.size() > 0) {
                    for (ServiceBookingEntity sv : services) {
                        totalPriceService = totalPriceService + sv.getPrice() / (long) session.getAttribute("night");
                    }
                }
                double totalRoomPrice = bd.getRoom().getPrice() * (100 - (double) session.getAttribute("discounts")) / 100;
                bd.setPrice(totalRoomPrice + totalPriceService);
                totalprice = totalprice + bd.getPrice();
            }
        }
        booking.setBookingstatus(bookingstatus.BOOKED);
        booking.setTotalPrice(totalprice);
        //model.addAttribute("booking", booking);
        session.setAttribute("booking", booking);
        return "booking";
    }

//    @RequestMapping("/view")
//    public String viewBooking(HttpSession session) {
//        session.removeAttribute("booking");
//        return "redirect:/view-booking";
//    }
//    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping(value = {"/service/{serviceId}"})
    public String buttonAddServicePage(Model model,
            @PathVariable("serviceId") int serviceId,
            HttpSession session
    ) {
        BookingEntity booking = (BookingEntity) session.getAttribute("booking");
        int quantity = 1;
        int roomId = (int) session.getAttribute("roomId");
        if (booking != null && roomId > 0 && booking.getBookingDetail() != null && booking.getBookingDetail().size() > 0) {
            for (BookingDetailEntity bd : booking.getBookingDetail()) {
                if (bd.getRoom().getId() == roomId) {
                    ServiceEntity service = serviceService.finbyId(serviceId);
                    List<ServiceBookingEntity> services = bd.getServiceBooking();
                    if (services != null && services.size() > 0) {
                        boolean isExist = false;
                        for (ServiceBookingEntity sv : services) {
                            if (sv.getService() != null && sv.getService().getId() == serviceId) {
                                isExist = true;
                                break;
                            }
                        }
                        if (!isExist) {
                            ServiceBookingEntity serviceBooking = new ServiceBookingEntity();
                            serviceBooking.setBookingDetail(bd);
                            serviceBooking.setPrice(service.getPrice());
                            serviceBooking.setQuantity(1);
                            serviceBooking.setServiceBookDate(LocalDate.now());
                            serviceBooking.setService(service);
                            services.add(serviceBooking);
                            bd.setServiceBooking(services);
                        } else {
                            for (ServiceBookingEntity sv : services) {
                                if (sv.getService() != null && sv.getService().getId() == serviceId) {
                                    int Quantity = sv.getQuantity() + 1;
                                    double totalPrice = Quantity * sv.getService().getPrice();
                                    sv.setQuantity(Quantity);
                                    sv.setPrice(totalPrice);
                                }
                            }
                            bd.setServiceBooking(services);
                        }
                        // nếu đã có service quantity +1;
                        // chưa tôn tại thì add mới                      
                    } else {
                        services = new ArrayList<>();
                        ServiceBookingEntity serviceBooking = new ServiceBookingEntity();
                        serviceBooking.setBookingDetail(bd);
                        serviceBooking.setPrice(service.getPrice());
                        serviceBooking.setQuantity(1);
                        serviceBooking.setServiceBookDate(LocalDate.now());
                        serviceBooking.setService(service);
                        services.add(serviceBooking);
                        bd.setServiceBooking(services);
                    }
                    session.setAttribute("serviceBooking", services);
                }
            }
        }

        session.setAttribute("booking", booking);
        model.addAttribute("service", serviceService.getService());
        return "redirect:/view-service";

    }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------

    @RequestMapping("/view-service")
    public String viewService(Model model,
            HttpSession session
    ) {

        double total = 0;
        BookingEntity booking = (BookingEntity) session.getAttribute("booking");
        BookingDetailEntity bookingDetailEntity = (BookingDetailEntity) session.getAttribute("detail");
//        if (bookingDetailEntity != null && bookingDetailEntity.getServiceBooking() != null && bookingDetailEntity.getServiceBooking().size() > 0) {
//            for (ServiceBookingEntity svb : bookingDetailEntity.getServiceBooking()) {
//                total = total + svb.getPrice();
//            }
//        }
//        booking.setTotalPrice(total);
//        session.setAttribute("bookingDetail", total);
        session.setAttribute("booking", booking);
        model.addAttribute("service", serviceService.getService());
        return "service_Booking";

    }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------
//

    @RequestMapping(value = {"/add-service/{roomId}"})
    public String addServicePage(Model model,
            HttpSession session,
             @PathVariable("roomId") int roomId
    ) {
        model.addAttribute("service", serviceService.getService());
        session.setAttribute("roomId", roomId);
        return "service_Booking";
    }


    @RequestMapping(value = {"/remove-service/{serviceId}"})
    public String removeServicePage(Model model,
            @PathVariable("serviceId") int serviceId,
            HttpSession session
    ) {
        BookingEntity booking = (BookingEntity) session.getAttribute("booking");
        int roomId = (int) session.getAttribute("roomId");
        if (booking != null && roomId > 0 && booking.getBookingDetail() != null && booking.getBookingDetail().size() > 0) {
            for (BookingDetailEntity bd : booking.getBookingDetail()) {
                if (bd.getRoom() != null && bd.getRoom().getId() == roomId) {
//                    ServiceEntity service = serviceService.findById(serviceId);
                    List<ServiceBookingEntity> servicesBooking = bd.getServiceBooking();
                    for (int i = 0; i < servicesBooking.size(); i++) {
                        if (servicesBooking.get(i).getService() != null && servicesBooking.get(i).getService().getId() == serviceId) {
                            servicesBooking.remove(i);
                            break;
                        }
                    }

                    bd.setServiceBooking(servicesBooking);
                    session.setAttribute("serviceBooking", servicesBooking);
                }
            }
        }
//         model.addAttribute("service", serviceService.getService());
//        model.addAttribute("service", serviceService.getService());
////        session.setAttribute("roomId", roomId);
//        session.setAttribute("", model);
        session.setAttribute("booking", booking);
        model.addAttribute("service", serviceService.getService());
        return "service_Booking";
    }
//[------------------------------------------------------------

//    @RequestMapping(value = "/credit-card", method = RequestMethod.POST)
//    public String result(Model model,HttpSession session,
//             @ModelAttribute("customer") GuestEntity guestEntity) {
//        BookingEntity bookingEntity = (BookingEntity) session.getAttribute("booking");
//        guestEntity.setBooking(bookingEntity);
//        session.setAttribute("guest", guestEntity);
//            return "creditCart";   
//    }
    @RequestMapping(value = {"/credit-card"})
    public String creditCardPage(Model model,
            @RequestParam(name = "full_name", required = false) String fullName,
            @RequestParam(name = "email", required = false) String email,
            @RequestParam(name = "gender", required = false) Gender gender,
            @RequestParam(name = "phone_number", required = false) String phone,
            @RequestParam(name = "address", required = false) String address,
            @RequestParam(name = "birthdate", required = false) String birthdate,
            HttpSession session
    ) {
        BookingEntity booking = (BookingEntity) session.getAttribute("booking");
        if (booking != null && booking.getBookingDetail() != null
                && booking.getBookingDetail().size() > 0) {

            booking.setFullName(fullName);
            booking.setGender(gender);
            booking.setEmail(email);
            booking.setPhone(phone);
            booking.setAddress(address);

            LocalDate birthDate = LocalDate.now();
            try {
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                birthDate = LocalDate.parse(birthdate, dateTimeFormatter);
            } catch (Exception e) {
            }
            booking.setBirthDay(birthDate);
        }
        model.addAttribute("booking", booking);
        return "creditCart";
    }

    //---------------------------------------------------------------------------------------------------------------------------------
    @RequestMapping(value = {"/price-service/{serviceId}"}, method = RequestMethod.POST)
    public String totalPriceServicePage(Model model,
            @PathVariable("serviceId") int serviceId,
            @RequestParam(name = "quantity") int quantity,
            HttpSession session
    ) {
        BookingEntity booking = (BookingEntity) session.getAttribute("booking");
        int roomId = (int) session.getAttribute("roomId");
        if (booking != null && roomId > 0 && booking.getBookingDetail() != null && booking.getBookingDetail().size() > 0) {
            for (BookingDetailEntity bd : booking.getBookingDetail()) {
                if (bd.getRoom() != null && bd.getRoom().getId() == roomId) {
                    ServiceEntity service = serviceService.finbyId(serviceId);
                    List<ServiceBookingEntity> servicesBooking = bd.getServiceBooking();
                    for (int i = 0; i < servicesBooking.size(); i++) {
                        if (servicesBooking.get(i).getService() != null && servicesBooking.get(i).getService().getId() == serviceId) {
                            double totalPrice = servicesBooking.get(i).getService().getPrice() * quantity;
                            servicesBooking.get(i).setQuantity(quantity);
                            servicesBooking.get(i).setPrice(totalPrice);
                        }
                    }
                    bd.setServiceBooking(servicesBooking);
                    session.setAttribute("serviceBooking", servicesBooking);
                }
            }
        }
        session.setAttribute("booking", booking);
        model.addAttribute("service", serviceService.getService());
        return "service_Booking";
    }
    //----------------------------------------------------------------------

    @RequestMapping(value = {"/remove-room/{roomId}"})
    public String removeroom(Model model,
            @PathVariable("roomId") int roomId,
            HttpSession session
    ) {
        BookingEntity booking = (BookingEntity) session.getAttribute("booking");
        List<BookingDetailEntity> details = booking.getBookingDetail();
        if (booking != null && details != null && details.size() > 0) {
            for (int i = 0; i < details.size(); i++) {
                if (details.get(i).getRoom().getId() == roomId) {
                    details.remove(i);
                }
            }
            booking.setBookingDetail(details);
        }
        return "redirect:/view-booking";
    }

    //-----------------------------------------------------------------------------------------------
    @RequestMapping(value = {"/confirm"})
    public String confirm(Model model,
            HttpSession session
    ) {

        model.addAttribute("genders", Gender.values());
        return "confirm";
    }
    //--------------------------------------------------------------

    @RequestMapping(value = {"/result-booking"}, method = RequestMethod.POST)
    public String resultPage(Model model,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "cardNumber", required = false) String cardNumber,
            @RequestParam(name = "expireDate", required = false) String expireDate,
            @RequestParam(name = "cvv", required = false) String cvv,
            HttpSession session
    ) {

        CreditCardEntity creditCardEntity = creditCardService.getcreCardEntity(cardNumber);
        LocalDate expDate = LocalDate.now();
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            expDate = LocalDate.parse(expireDate, dateTimeFormatter);
        } catch (Exception e) {
        }
        if (creditCardEntity != null && creditCardEntity.getName().equals(name) && creditCardEntity.getCcvCode().equals(cvv)) {
            BookingEntity booking = (BookingEntity) session.getAttribute("booking");
            if (creditCardEntity.getBalance() >= booking.getTotalPrice()) {
                if (booking != null && booking.getBookingDetail() != null
                        && booking.getBookingDetail().size() > 0) {
                    bookingService.save(booking);
                    List<BookingDetailEntity> bookingDetail = booking.getBookingDetail();
                    for (BookingDetailEntity bd : bookingDetail) {
                        bookingDetailService.save(bd);
                        List<ServiceBookingEntity> services = bd.getServiceBooking();
                        for (ServiceBookingEntity service : services) {
                            serviceBookingService.save(service);
                        }
                    }
                }
                model.addAttribute("booking", booking);
                double balance = creditCardEntity.getBalance() - booking.getTotalPrice();
                creditCardEntity.setBalance(balance);
                creditCardService.save(creditCardEntity);

                paymentEntity payment = new paymentEntity();
                payment.setAmount(booking.getTotalPrice());
                payment.setBooking(booking);
                payment.setPaymentDate(LocalDate.now());
                payment.setCreditCard(creditCardEntity);
                paymentService.save(payment);

                model.addAttribute("message", "You have successfully paid !");
                session.removeAttribute("booking");
                return "payment-page";
            } else {
                model.addAttribute("message", "There is not enough money in your account to pay !");
                return "creditCart";
            }
        } else {
            model.addAttribute("message", "There is not enough money in your account to pay !");
            return "creditCart";
        }

    }

}

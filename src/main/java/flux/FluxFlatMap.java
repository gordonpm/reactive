package flux;

import flux.helper.OrderService;
import flux.helper.UserService;
import utils.Util;

public class FluxFlatMap {

    public static void main(String[] args) {
        UserService.getUsers()
                .flatMap(user -> OrderService.getOrders(user.getUserId()))
                .subscribe(Util.subscriber());
        Util.sleepSeconds(60);
    }
}

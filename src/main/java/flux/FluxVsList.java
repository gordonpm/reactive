package flux;

import utils.NameGenerator;
import utils.Util;

import java.util.List;

public class FluxVsList {
    public static void main(String[] args) {
        List<String> names = NameGenerator.getNames(5);
        System.out.println(names);

        NameGenerator.getNamesFlux(5)
                .subscribe(Util.onNext());
    }
}

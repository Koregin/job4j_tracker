package ru.job4j.stream;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class ProfilesTest {
    @Test
    public void whenCollectAddresses() {
        List<Profile> profiles = new ArrayList<Profile>();
        profiles.add(new Profile(new Address("Albuquerque",
                "Mainstreet", 10, 123)));
        profiles.add(new Profile(new Address("New York",
                "Wallstreet", 5, 355)));
        profiles.add(new Profile(new Address("Washington",
                "Linkoln", 55, 5)));
        profiles.add(new Profile(new Address("Las Vegas",
                "Casinostreet", 25, 17)));
        profiles.add(new Profile(new Address("Los Angeles",
                "Angelstreet", 355, 28)));
        List<Address> expected = new ArrayList<Address>();
        expected.add(new Address("Albuquerque", "Mainstreet", 10, 123));
        expected.add(new Address("New York", "Wallstreet", 5, 355));
        expected.add(new Address("Washington", "Linkoln", 55, 5));
        expected.add(new Address("Las Vegas", "Casinostreet", 25, 17));
        expected.add(new Address("Los Angeles", "Angelstreet", 355, 28));
        assertThat(expected, Profiles.collect(profiles));
    }

    private void assertThat(List<Address> expected, List<Address> collect) {
    }
}
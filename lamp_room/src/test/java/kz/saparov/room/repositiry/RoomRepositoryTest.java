package kz.saparov.room.repositiry;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import kz.saparov.room.entity.Country;
import kz.saparov.room.entity.Room;
import kz.saparov.room.repository.RoomRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class RoomRepositoryTest {
	
	@Autowired
	private RoomRepository roomRepository;
	
	@Before
    public void setUp(){
		Country Kaz = new Country("KZ","Казахстан");
        Room room = new Room(1L, "num1", true, Kaz);
        roomRepository.save(room);
    }
	
	@Test
	public void shouldReturnOneUpdatedRow() {
		int rows = roomRepository.changeRoomLigth(1L, false);
		assertEquals(1, rows);
	}
}

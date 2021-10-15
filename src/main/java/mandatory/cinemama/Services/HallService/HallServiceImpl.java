package mandatory.cinemama.Services.HallService;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;
import mandatory.cinemama.Entities.Hall;
import mandatory.cinemama.Repositories.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HallServiceImpl implements HallService {

  private HallRepository hallRepository;

  @Autowired
  public HallServiceImpl(HallRepository hallRepository) {
    this.hallRepository = hallRepository;
  }

  @Override
  public List<Hall> findAllHalls() {
    List<Hall> halls = hallRepository.findAll();
    return halls;
  }

  @Override
  public List<Hall> findHallsByTheaterId(Long id) {
    List<Hall> halls = hallRepository.findByTheaterId(id);
    return halls;
  }

  @Override
  public Hall findHallById(Long id) {
    Optional<Hall> hall = hallRepository.findById(id);
    return hall.get();
  }

  @Override
  public Hall findHallByName(String name) {
    Optional<Hall> hall = hallRepository.findByName(name);
    return hall.get();
  }

  @Override
  public void updateHallById(Hall hall, Long id) {
    Optional<Hall> foundHall = hallRepository.findById(id);
    if (foundHall.isPresent()) {
      foundHall.get().setName(hall.getName());
      foundHall.get().setTheater(hall.getTheater());
      hallRepository.save(foundHall.get());
    } else {
      System.out.println("Error");
    }
  }

  @Override
  public void addHall(Hall hall) {
    hallRepository.save(hall);
  }

  @Override
  public void deleteHallById(Long id) {
    hallRepository.deleteById(id);
  }

}

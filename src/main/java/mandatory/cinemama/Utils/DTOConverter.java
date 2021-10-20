package mandatory.cinemama.Utils;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;

public class DTOConverter {

  private ModelMapper modelMapper = new ModelMapper();

  public <S, T> T mapDTO(S source, Class<T> targetClass) {
    return modelMapper.map(source, targetClass);
  }

  public <S, T> List<T> mapListDTO(List<S> source, Class<T> targetClass) {
    return source
      .stream()
      .map(element -> modelMapper.map(element, targetClass))
      .collect(Collectors.toList());
  }
}

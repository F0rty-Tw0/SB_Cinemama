package mandatory.cinemama.Utils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;

public class DTOConverter {

  private static ModelMapper modelMapper = new ModelMapper();

  public static <S, T> T mapDTO(S source, Class<T> targetClass) {
    return modelMapper.map(source, targetClass);
  }

  public static <S, T> List<T> mapListDTO(
    List<S> source,
    Class<T> targetClass
  ) {
    return source
      .stream()
      .map(element -> modelMapper.map(element, targetClass))
      .collect(Collectors.toList());
  }

  public static <S, T> Set<T> mapSetDTO(Set<S> source, Class<T> targetClass) {
    return source
      .stream()
      .map(element -> modelMapper.map(element, targetClass))
      .collect(Collectors.toSet());
  }
}

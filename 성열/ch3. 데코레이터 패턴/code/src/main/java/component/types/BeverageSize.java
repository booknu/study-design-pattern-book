package component.types;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BeverageSize {
	SHORT(246),
	TALL(354),
	GRANDE(473),
	VENTI(591);

	private final double milliliters;
}

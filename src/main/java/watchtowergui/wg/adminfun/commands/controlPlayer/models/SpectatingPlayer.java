package watchtowergui.wg.adminfun.commands.controlPlayer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bukkit.Location;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpectatingPlayer {

    private UUID spectatingPlayerUUID;

    private String lastGamemode;

    private Location location;
}

package watchtowergui.wg.adminfun.commands.controlPlayer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bukkit.Location;

import java.util.UUID;

@Data
@AllArgsConstructor
public class SpectatingPlayer {

    private UUID controlledPlayerUUID;

    private UUID spectatingPlayerUUID;

    private String lastGameMode;

    private Location location;
}

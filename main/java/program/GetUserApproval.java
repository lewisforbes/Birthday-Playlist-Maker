package program;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.SpotifyHttpManager;
import com.wrapper.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;

import java.net.URI;

public class GetUserApproval {

    private static final String clientId = "<yours>";
    private static final String clientSecret = "<yours>";
//    private static final URI redirectUri = SpotifyHttpManager.makeUri("http://localhost:8080/birthdayplaylist/result");
    private static final URI redirectUri = SpotifyHttpManager.makeUri("http://lewis-forbes.us-east-2.elasticbeanstalk.com/birthday/result");

    public static SpotifyApi api = new SpotifyApi.Builder().setClientId(clientId).setClientSecret(clientSecret).setRedirectUri(redirectUri).build();

    public static String mkURI() {
        AuthorizationCodeUriRequest authorizationCodeUriRequest = api.authorizationCodeUri()
                .scope("playlist-modify-public,user-read-private,ugc-image-upload")
                .show_dialog(true)
                .build();
        final URI uri = authorizationCodeUriRequest.execute();
        return uri.toString();
    }
}

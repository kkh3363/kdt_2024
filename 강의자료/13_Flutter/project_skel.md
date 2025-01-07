- main.dart
```
import 'package:flutter/material.dart';
import 'package:vid_player/screen/home_screen.dart';

void main() {
  runApp(
    MaterialApp(
      debugShowCheckedModeBanner: false,
      home: HomeScreen(),
    ),
  );
}
```

- screen/home_screen.dart
```
import 'package:flutter/material.dart';

class HomeScreen extends StatelessWidget {
  const HomeScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: Text('data'),
    );
  }
}
```
<uses-permission android:name="android.permission.INTERNET" />

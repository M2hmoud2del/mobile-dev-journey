import 'package:cupertino_ui/cupertino_ui.dart';

import 'home_screen.dart';

void main() => runApp(CareerLens());

class CareerLens extends StatelessWidget {
  const CareerLens({super.key});

  @override
  Widget build(BuildContext context) {
    return CupertinoApp(
      debugShowCheckedModeBanner: false,
      theme: CupertinoThemeData(
        primaryColor: CupertinoColors.systemBlue,
        barBackgroundColor: CupertinoColors.systemBackground,
        scaffoldBackgroundColor: CupertinoColors.systemBackground,
      ),
      home: HomeScreen(),
    );
  }
}

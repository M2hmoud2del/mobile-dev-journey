import 'package:cupertino_ui/cupertino_ui.dart';
import 'package:animated_text_kit/animated_text_kit.dart';

void main(){
  runApp(JopApp());
}

class JopApp extends StatelessWidget {
  const JopApp({super.key});

  @override
  Widget build(BuildContext context) {
    return CupertinoApp(
      theme: CupertinoThemeData(
        barBackgroundColor: CupertinoColors.systemGreen,
        scaffoldBackgroundColor: CupertinoColors.systemGrey6,
        primaryColor: CupertinoColors.systemOrange
      ),
      debugShowCheckedModeBanner: false,
      home: JobScreen(),
    );
  }
  
}

class   JobScreen extends StatefulWidget {
  const JobScreen({super.key});

  @override
  State<StatefulWidget> createState() => _JobScreen();

}

class _JobScreen extends State<StatefulWidget> {
  var _jobTitle = 'Android or IOS Developer?';
  var _isBtnClicked = false;

  void _revealAnswer(){
    setState(() {
          _jobTitle = 'Mobile Developer';
          _isBtnClicked = true;
        });
  }
  @override
  Widget build(BuildContext context) {
    return CupertinoPageScaffold(
      navigationBar: CupertinoNavigationBar(
        middle: Text('Job Guess'),
        automaticBackgroundVisibility: false,
      ),
      child: Center(
        child: Column(
          mainAxisAlignment: .center,
          children: [
            Container(
              margin: EdgeInsets.all(16),
              child: DefaultTextStyle(
                style: TextStyle(
                  fontSize: 24,
                  fontWeight: .bold,
                  color: CupertinoColors.black,
                ),
                child: _isBtnClicked
                    ? AnimatedTextKit(
                  animatedTexts: [
                    TyperAnimatedText(
                      _jobTitle,
                      speed: Duration(milliseconds: 300),
                    ),
                  ],
                  totalRepeatCount: 1,
                )
                    : Text(_jobTitle),
              ),
            ),
            CupertinoButton(
              child: Text("Show The Answer"),
              onPressed: _isBtnClicked ? null : _revealAnswer,
            ),
            Icon(CupertinoIcons.up_arrow),
          ],
        ),
      ),
    );
  }

}
import 'package:cupertino_ui/cupertino_ui.dart';

import 'job_screen.dart';

class HomeScreen extends StatelessWidget {
  const HomeScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return CupertinoPageScaffold(
      navigationBar: CupertinoNavigationBar(
        middle: Text('Career Lens'),
        automaticBackgroundVisibility: false,
      ),
      child: SearchWidget(),
    );
  }
}

class SearchWidget extends StatefulWidget {
  const SearchWidget({super.key});

  @override
  State<StatefulWidget> createState() => _SearchWidgetState();
}

class _SearchWidgetState extends State<SearchWidget> {
  final _textController = TextEditingController();

  void _openJobScreen() {
    Navigator.push(
      context,
      CupertinoPageRoute(builder: (_) => JobScreen(_textController.text)),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Padding(
        padding: .all(16),
        child: Column(
          mainAxisAlignment: .center,
          children: [
            CupertinoTextField(
              textInputAction: .search,
              onSubmitted: (_) {
                _openJobScreen();
              },
              placeholder: 'Job title',
              controller: _textController,
            ),
            CupertinoButton(child: Text('Search'), onPressed: _openJobScreen),
          ],
        ),
      ),
    );
  }
}

import 'package:flutter/material.dart';
import 'package:isar_test/models/user.dart';
import 'package:isar_test/screen/home_screen.dart';
import 'package:path_provider/path_provider.dart';
import 'package:isar/isar.dart';

void main() async{
  WidgetsFlutterBinding.ensureInitialized();
  final dir = await getApplicationDocumentsDirectory();
  final isar = await Isar.open(
    [UserSchema],
    directory: dir.path,
  );
  final newUser = User()..name='홍길동'..age=36;

  await isar.writeTxn(() async{
    await isar.users.put(newUser);
  });
  final existingUser = await isar.users.get(newUser.id);
  final name = existingUser?.name;
  print( '+++++++++++++++++++:: $name' );
  runApp(
    MaterialApp(
      debugShowCheckedModeBanner: false,
      home: HomeScreen(),
    ),
  );
}
